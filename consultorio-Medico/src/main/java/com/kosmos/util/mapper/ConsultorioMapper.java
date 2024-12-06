package com.kosmos.util.mapper;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.presentation.dto.consultorio.ConsultorioRequest;
import com.kosmos.presentation.dto.consultorio.ConsultorioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConsultorioMapper {
    ConsultorioMapper INSTANCE = Mappers.getMapper(ConsultorioMapper.class);

    ConsultorioResponse consultorioToConsultorioResponse(Consultorio consultorio);

    Consultorio consultorioRequestToConsultorio(ConsultorioRequest consultorioRequest);
}
