package com.kosmos.presentation.dto.doctor;

import jakarta.validation.constraints.NotBlank;

public record DoctorRequest(
        @NotBlank String nombre,
        @NotBlank String apellidoPaterno,
        @NotBlank String apellidoMaterno,
        @NotBlank String especialidad
) {
}
