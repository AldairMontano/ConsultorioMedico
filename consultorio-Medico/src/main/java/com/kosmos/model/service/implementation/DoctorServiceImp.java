package com.kosmos.model.service.implementation;

import com.kosmos.model.entity.Doctor;
import com.kosmos.model.repository.DoctorRepository;
import com.kosmos.model.service.iService.IDoctorService;
import com.kosmos.presentation.dto.doctor.DoctorRequest;
import com.kosmos.presentation.dto.doctor.DoctorResponse;
import com.kosmos.util.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements IDoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImp(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public List<DoctorResponse> obtenerDoctores() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::doctorToDoctorResponse)
                .toList();
    }

    @Override
    public DoctorResponse guardarDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.doctorRequestToDoctor(doctorRequest);
        return doctorMapper.doctorToDoctorResponse(doctorRepository.save(doctor));
    }

    @Override
    public Optional<DoctorResponse> actualizarDoctor(DoctorRequest doctorRequest, Long idDoctor) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(idDoctor);
        if (doctorOpt.isEmpty()) {
            return Optional.empty();
        }
        Doctor updatedDoctor = doctorMapper.doctorRequestToDoctor(doctorRequest);
        updatedDoctor.setId(idDoctor);
        return Optional.of(doctorMapper.doctorToDoctorResponse(doctorRepository.save(updatedDoctor)));
    }

    @Override
    public Optional<DoctorResponse> obtenerDoctorPorId(Long idDoctor) {
        return doctorRepository.findById(idDoctor).map(doctorMapper::doctorToDoctorResponse);
    }

    @Override
    public void eliminarDoctor(Long idDoctor) {
        doctorRepository.deleteById(idDoctor);
    }
}
