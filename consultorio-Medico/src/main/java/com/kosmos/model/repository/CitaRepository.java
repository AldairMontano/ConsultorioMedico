package com.kosmos.model.repository;

import com.kosmos.model.entity.Cita;
import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByHorarioBetween(LocalDateTime inicio, LocalDateTime fin);
    List<Cita> findByDoctorAndHorarioBetween(Doctor doctor, LocalDateTime inicio, LocalDateTime fin);
    Optional<Cita> findByConsultorioAndHorario(Consultorio consultorio, LocalDateTime horario);
    List<Cita> findByConsultorioAndHorarioBetween(Consultorio consultorio, LocalDateTime inicio, LocalDateTime fin);
}
