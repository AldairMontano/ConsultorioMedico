package com.kosmos.model.service.iService;

import com.kosmos.presentation.dto.doctor.DoctorRequest;
import com.kosmos.presentation.dto.doctor.DoctorResponse;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {
    List<DoctorResponse> obtenerDoctores();

    DoctorResponse guardarDoctor(DoctorRequest doctorRequest);

    Optional<DoctorResponse> actualizarDoctor(DoctorRequest doctorRequest, Long idDoctor);

    Optional<DoctorResponse> obtenerDoctorPorId(Long idDoctor);

    void eliminarDoctor(Long idDoctor);
}
