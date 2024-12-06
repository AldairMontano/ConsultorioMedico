package com.kosmos.presentation.dto.doctor;

public record DoctorResponse(
        Long id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String especialidad
) {
}
