package com.kosmos.model.service.iService;

import com.kosmos.presentation.dto.consultorio.ConsultorioRequest;
import com.kosmos.presentation.dto.consultorio.ConsultorioResponse;

import java.util.List;
import java.util.Optional;

public interface IConsultorioService {
    List<ConsultorioResponse> obtenerConsultorios();
    ConsultorioResponse guardarConsultorio(ConsultorioRequest consultorioRequest);
    Optional<ConsultorioResponse> updateConsultorio(ConsultorioRequest consultorioRequest, Long idConsultorio);
    Optional<ConsultorioResponse> obtenerConsultorioPorId(Long idConsultorio);
    void eliminarConsultorio(Long idConsultorio);

}
