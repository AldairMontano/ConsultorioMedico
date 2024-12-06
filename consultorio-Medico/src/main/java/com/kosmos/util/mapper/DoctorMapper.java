package com.kosmos.util.mapper;

import com.kosmos.model.entity.Doctor;
import com.kosmos.presentation.dto.doctor.DoctorRequest;
import com.kosmos.presentation.dto.doctor.DoctorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorResponse doctorToDoctorResponse(Doctor doctor);
    Doctor doctorRequestToDoctor(DoctorRequest doctorRequest);
}
