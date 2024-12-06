package com.kosmos.presentation.dto.cita;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;

import java.time.LocalDateTime;

public record CitaResponse(
        Long id,
        Doctor doctor,
        Consultorio consultorio,
        String nombrePaciente,
        LocalDateTime horario
) {
}
