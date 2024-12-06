package com.kosmos.presentation.dto.cita;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CitaRequest {
        @NotNull Doctor doctor;
        @NotNull Consultorio consultorio;
        @NotBlank String nombrePaciente;
        @FutureOrPresent LocalDateTime horario;

        public @NotNull Doctor getDoctor() {
                return doctor;
        }

        public void setDoctor(@NotNull Doctor doctor) {
                this.doctor = doctor;
        }

        public @NotNull Consultorio getConsultorio() {
                return consultorio;
        }

        public void setConsultorio(@NotNull Consultorio consultorio) {
                this.consultorio = consultorio;
        }

        public @NotBlank String getNombrePaciente() {
                return nombrePaciente;
        }

        public void setNombrePaciente(@NotBlank String nombrePaciente) {
                this.nombrePaciente = nombrePaciente;
        }

        public @FutureOrPresent LocalDateTime getHorario() {
                return horario;
        }

        public void setHorario(@FutureOrPresent LocalDateTime horario) {
                this.horario = horario;
        }
}
