package com.kosmos.configuration;

import com.kosmos.model.entity.Consultorio;
import com.kosmos.model.entity.Doctor;
import com.kosmos.model.repository.ConsultorioRepository;
import com.kosmos.model.repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final DoctorRepository doctorRepository;
    private final ConsultorioRepository consultorioRepository;

    public DataInitializer(DoctorRepository doctorRepository, ConsultorioRepository consultorioRepository) {
        this.doctorRepository = doctorRepository;
        this.consultorioRepository = consultorioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar 5 doctores
        Doctor doctor1 = new Doctor("Juan", "Perez", "Lopez", "Medicina Interna");
        Doctor doctor2 = new Doctor("Ana", "Gomez", "Martinez", "Pediatría");
        Doctor doctor3 = new Doctor("Carlos", "Fernandez", "Rodriguez", "Cirugía");
        Doctor doctor4 = new Doctor("Lucia", "Diaz", "Garcia", "Ginecología");
        Doctor doctor5 = new Doctor("Pedro", "Morales", "Sanchez", "Cardiología");

        doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3, doctor4, doctor5));

        // Crear y guardar 5 consultorios
        Consultorio consultorio1 = new Consultorio(101, 1);
        Consultorio consultorio2 = new Consultorio(102, 1);
        Consultorio consultorio3 = new Consultorio(103, 2);
        Consultorio consultorio4 = new Consultorio(104, 2);
        Consultorio consultorio5 = new Consultorio(105, 3);

        consultorioRepository.saveAll(List.of(consultorio1, consultorio2, consultorio3, consultorio4, consultorio5));
    }
}
