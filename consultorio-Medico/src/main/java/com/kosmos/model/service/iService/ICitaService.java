package com.kosmos.model.service.iService;

import com.kosmos.model.entity.Cita;
import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import com.kosmos.presentation.dto.cita.CitaRequest;
import com.kosmos.presentation.dto.cita.CitaResponse;
import com.kosmos.presentation.dto.doctor.DoctorResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICitaService {

    void validarCita(Cita cita);
    CitaResponse guardarCita(CitaRequest cita);
    CitaResponse cancelarCita(Long idCita);
    List<CitaResponse> obtenerCitas();
    CitaResponse actualizarCita(CitaRequest cita, Long idCita);
    List<CitaResponse> obtenerCitasPorHorario(LocalDateTime inicio, LocalDateTime fin);
    List<CitaResponse> obtenerCitasPorDoctorYHorario(Long idDoctor, LocalDateTime inicio, LocalDateTime fin);
    Optional<CitaResponse> obtenerCitasPorConsultorioYHorario(Long idConsultorio, LocalDateTime horario);
    List<CitaResponse> findByConsultorioAndHorarioBetween(Consultorio consultorio, LocalDateTime inicio, LocalDateTime fin);

}
