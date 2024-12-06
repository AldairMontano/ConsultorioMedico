package com.kosmos.util.mapper;

import com.kosmos.model.entity.Doctor;
import com.kosmos.presentation.dto.doctor.DoctorRequest;
import com.kosmos.presentation.dto.doctor.DoctorResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-06T13:36:43-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponse doctorToDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String apellidoPaterno = null;
        String apellidoMaterno = null;
        String especialidad = null;

        id = doctor.getId();
        nombre = doctor.getNombre();
        apellidoPaterno = doctor.getApellidoPaterno();
        apellidoMaterno = doctor.getApellidoMaterno();
        especialidad = doctor.getEspecialidad();

        DoctorResponse doctorResponse = new DoctorResponse( id, nombre, apellidoPaterno, apellidoMaterno, especialidad );

        return doctorResponse;
    }

    @Override
    public Doctor doctorRequestToDoctor(DoctorRequest doctorRequest) {
        if ( doctorRequest == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setApellidoPaterno( doctorRequest.apellidoPaterno() );
        doctor.setNombre( doctorRequest.nombre() );
        doctor.setApellidoMaterno( doctorRequest.apellidoMaterno() );
        doctor.setEspecialidad( doctorRequest.especialidad() );

        return doctor;
    }
}
