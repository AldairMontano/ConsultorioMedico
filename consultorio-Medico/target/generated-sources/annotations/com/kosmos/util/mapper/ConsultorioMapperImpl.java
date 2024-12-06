package com.kosmos.util.mapper;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.presentation.dto.consultorio.ConsultorioRequest;
import com.kosmos.presentation.dto.consultorio.ConsultorioResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-06T13:36:43-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ConsultorioMapperImpl implements ConsultorioMapper {

    @Override
    public ConsultorioResponse consultorioToConsultorioResponse(Consultorio consultorio) {
        if ( consultorio == null ) {
            return null;
        }

        Long id = null;
        int numero = 0;
        int piso = 0;

        id = consultorio.getId();
        numero = consultorio.getNumero();
        piso = consultorio.getPiso();

        ConsultorioResponse consultorioResponse = new ConsultorioResponse( id, numero, piso );

        return consultorioResponse;
    }

    @Override
    public Consultorio consultorioRequestToConsultorio(ConsultorioRequest consultorioRequest) {
        if ( consultorioRequest == null ) {
            return null;
        }

        Consultorio consultorio = new Consultorio();

        consultorio.setNumero( consultorioRequest.numero() );
        consultorio.setPiso( consultorioRequest.piso() );

        return consultorio;
    }
}
