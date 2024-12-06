package com.kosmos.util.mapper;

import com.kosmos.model.entity.Cita;
import com.kosmos.presentation.dto.cita.CitaRequest;
import com.kosmos.presentation.dto.cita.CitaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    CitaResponse citaToCitaResponse(Cita cita);

    Cita citaRequestToCita(CitaRequest citaRequest);
}
