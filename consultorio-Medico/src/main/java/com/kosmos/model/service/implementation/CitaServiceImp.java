package com.kosmos.model.service.implementation;

import com.kosmos.model.entity.Cita;
import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import com.kosmos.model.repository.CitaRepository;
import com.kosmos.model.repository.ConsultorioRepository;
import com.kosmos.model.repository.DoctorRepository;
import com.kosmos.model.service.iService.ICitaService;
import com.kosmos.presentation.dto.cita.CitaRequest;
import com.kosmos.presentation.dto.cita.CitaResponse;
import com.kosmos.util.mapper.CitaMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImp implements ICitaService {
    private final CitaRepository citaRepository;
    private final DoctorRepository doctorRepository;
    private final ConsultorioRepository consultorioRepository;
    private final CitaMapper citaMapper;

    public CitaServiceImp(CitaRepository citaRepository, DoctorRepository doctorRepository, ConsultorioRepository consultorioRepository, CitaMapper citaMapper) {
        this.citaRepository = citaRepository;
        this.doctorRepository = doctorRepository;
        this.consultorioRepository = consultorioRepository;
        this.citaMapper = citaMapper;
    }

    @Override
    public void validarCita(Cita cita) {
        // Validar que no se agende en un consultorio a la misma hora
        if (citaRepository.findByConsultorioAndHorario(cita.getConsultorio(), cita.getHorario()).isPresent()) {
            throw new IllegalArgumentException("El consultorio está ocupado en ese horario.");
        }

        // Validar que no se agende con el mismo doctor a la misma hora
        if (!citaRepository.findByDoctorAndHorarioBetween(cita.getDoctor(), cita.getHorario().minusMinutes(1), cita.getHorario().plusMinutes(1)).isEmpty()) {
            throw new IllegalArgumentException("El doctor ya tiene una cita en ese horario.");
        }

        // Validar que un paciente no tenga citas en menos de 2 horas el mismo día
        LocalDateTime inicioDia = cita.getHorario().toLocalDate().atStartOfDay();
        LocalDateTime finDia = inicioDia.plusDays(1);
        List<Cita> citasPaciente = citaRepository.findByHorarioBetween(inicioDia, finDia)
                .stream()
                .filter(c -> c.getNombrePaciente().equalsIgnoreCase(cita.getNombrePaciente()))
                .toList();
        for (Cita c : citasPaciente) {
            if (c.getHorario().isAfter(cita.getHorario().minusHours(2)) &&
                    c.getHorario().isBefore(cita.getHorario().plusHours(2))) {
                throw new IllegalArgumentException("El paciente tiene otra cita en un intervalo menor a 2 horas.");
            }
        }

        // Validar que un doctor no tenga más de 8 citas al día
        long citasDelDia = citaRepository.findByDoctorAndHorarioBetween(
                cita.getDoctor(), inicioDia, finDia).size();
        if (citasDelDia >= 8) {
            throw new IllegalArgumentException("El doctor ya alcanzó el límite de 8 citas en el día.");
        }
    }

    @Override
    public CitaResponse guardarCita(CitaRequest citaRequest) {
        Cita cita = citaMapper.citaRequestToCita(citaRequest);
        validarCita(cita);
        return citaMapper.citaToCitaResponse(citaRepository.save(cita));
    }

    @Override
    public CitaResponse cancelarCita(Long idCita) {
        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new IllegalArgumentException("La cita no existe."));
        citaRepository.delete(cita);
        return citaMapper.citaToCitaResponse(cita);
    }

    @Override
    public List<CitaResponse> obtenerCitas() {
        return citaRepository.findAll().stream()
                .map(citaMapper::citaToCitaResponse)
                .toList();
    }

    @Override
    public CitaResponse actualizarCita(CitaRequest citaRequest, Long idCita) {
        Cita citaExistente = citaRepository.findById(idCita)
                .orElseThrow(() -> new IllegalArgumentException("La cita no existe."));
        Cita citaActualizada = citaMapper.citaRequestToCita(citaRequest);
        citaActualizada.setId(citaExistente.getId());
        validarCita(citaActualizada);
        return citaMapper.citaToCitaResponse(citaRepository.save(citaActualizada));
    }

    @Override
    public List<CitaResponse> obtenerCitasPorHorario(LocalDateTime inicio, LocalDateTime fin) {
        return citaRepository.findByHorarioBetween(inicio, fin).stream()
                .map(citaMapper::citaToCitaResponse)
                .toList();
    }

    @Override
    public List<CitaResponse> obtenerCitasPorDoctorYHorario(Long idDoctor, LocalDateTime inicio, LocalDateTime fin) {
        Doctor doctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new IllegalArgumentException("El doctor no existe."));
        return citaRepository.findByDoctorAndHorarioBetween(doctor, inicio, fin).stream()
                .map(citaMapper::citaToCitaResponse)
                .toList();
    }

    @Override
    public Optional<CitaResponse> obtenerCitasPorConsultorioYHorario(Long idConsultorio, LocalDateTime horario) {
        Consultorio consultorio = consultorioRepository.findById(idConsultorio)
                .orElseThrow(() -> new IllegalArgumentException("El consultorio no existe."));
        return citaRepository.findByConsultorioAndHorario(consultorio, horario).map(citaMapper::citaToCitaResponse);
    }

    @Override
    public List<CitaResponse> findByConsultorioAndHorarioBetween(Consultorio consultorio, LocalDateTime inicio, LocalDateTime fin) {
        return citaRepository.findByHorarioBetween(inicio, fin).stream()
                .filter(cita -> cita.getConsultorio().equals(consultorio))
                .map(citaMapper::citaToCitaResponse)
                .toList();
    }
}
