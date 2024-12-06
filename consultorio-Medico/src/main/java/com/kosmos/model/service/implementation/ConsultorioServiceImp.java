package com.kosmos.model.service.implementation;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.repository.ConsultorioRepository;
import com.kosmos.model.service.iService.IConsultorioService;
import com.kosmos.presentation.dto.consultorio.ConsultorioRequest;
import com.kosmos.presentation.dto.consultorio.ConsultorioResponse;
import com.kosmos.util.mapper.ConsultorioMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioServiceImp implements IConsultorioService {

    private final ConsultorioRepository consultorioRepository;
    private final ConsultorioMapper consultorioMapper;

    public ConsultorioServiceImp(ConsultorioRepository consultorioRepository, ConsultorioMapper consultorioMapper) {
        this.consultorioRepository = consultorioRepository;
        this.consultorioMapper = consultorioMapper;
    }

    @Override
    public List<ConsultorioResponse> obtenerConsultorios() {
        return consultorioRepository.findAll().stream().map(consultorioMapper::consultorioToConsultorioResponse).toList();
    }

    @Override
    public ConsultorioResponse guardarConsultorio(ConsultorioRequest consultorioRequest) {
        Consultorio consultorio = consultorioMapper.consultorioRequestToConsultorio(consultorioRequest);
        return consultorioMapper.consultorioToConsultorioResponse(consultorioRepository.save(consultorio));
    }

    @Override
    public Optional<ConsultorioResponse> updateConsultorio(ConsultorioRequest consultorioRequest, Long idConsultorio) {
        Optional<Consultorio> consultorio = consultorioRepository.findById(idConsultorio);
        if (consultorio.isEmpty()) {
            return Optional.empty();
        }
        Consultorio consultorioUpdated = consultorioMapper.consultorioRequestToConsultorio(consultorioRequest);
        consultorioUpdated.setId(idConsultorio);
        return Optional.of(consultorioMapper.consultorioToConsultorioResponse(consultorioRepository.save(consultorioUpdated)));
    }

    @Override
    public Optional<ConsultorioResponse> obtenerConsultorioPorId(Long idConsultorio) {
        return consultorioRepository.findById(idConsultorio)
                .map(consultorioMapper::consultorioToConsultorioResponse);
    }

    @Override
    public void eliminarConsultorio(Long idConsultorio) {
        consultorioRepository.deleteById(idConsultorio);
    }
}
