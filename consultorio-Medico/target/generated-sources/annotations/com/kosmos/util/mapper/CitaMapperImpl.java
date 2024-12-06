package com.kosmos.util.mapper;

import com.kosmos.model.entity.Cita;
import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import com.kosmos.presentation.dto.cita.CitaRequest;
import com.kosmos.presentation.dto.cita.CitaResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-06T13:36:43-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaResponse citaToCitaResponse(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        Long id = null;
        Doctor doctor = null;
        Consultorio consultorio = null;
        String nombrePaciente = null;
        LocalDateTime horario = null;

        id = cita.getId();
        doctor = cita.getDoctor();
        consultorio = cita.getConsultorio();
        nombrePaciente = cita.getNombrePaciente();
        horario = cita.getHorario();

        CitaResponse citaResponse = new CitaResponse( id, doctor, consultorio, nombrePaciente, horario );

        return citaResponse;
    }

    @Override
    public Cita citaRequestToCita(CitaRequest citaRequest) {
        if ( citaRequest == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setDoctor( citaRequest.getDoctor() );
        cita.setConsultorio( citaRequest.getConsultorio() );
        cita.setHorario( citaRequest.getHorario() );
        cita.setNombrePaciente( citaRequest.getNombrePaciente() );

        return cita;
    }
}
