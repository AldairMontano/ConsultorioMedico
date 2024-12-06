package com.kosmos.presentation.dto.consultorio;

import jakarta.validation.constraints.Min;

public record ConsultorioRequest(
        @Min(value = 1, message = "El numero debe ser mayo a 0") int numero,
        @Min(value = 1, message = "El piso debe ser mayo a 0") int piso
) {
}
