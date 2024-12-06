package com.kosmos.presentation.controller;

import com.kosmos.model.service.iService.ICitaService;
import com.kosmos.model.service.iService.IConsultorioService;
import com.kosmos.model.service.iService.IDoctorService;
import com.kosmos.presentation.dto.cita.CitaRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final ICitaService citaService;
    private final IDoctorService doctorService;
    private final IConsultorioService consultorioService;

    public CitaController(ICitaService citaService, IDoctorService doctorService, IConsultorioService consultorioService) {
        this.citaService = citaService;
        this.doctorService = doctorService;
        this.consultorioService = consultorioService;
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new CitaRequest());
        model.addAttribute("doctores", doctorService.obtenerDoctores());
        model.addAttribute("consultorios", consultorioService.obtenerConsultorios());
        return "citas/crear";
    }

    @PostMapping("/crear")
    public String crearCita(@Valid @ModelAttribute CitaRequest cita, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("doctores", doctorService.obtenerDoctores());
            model.addAttribute("consultorios", consultorioService.obtenerConsultorios());
            return "citas/crear";
        }
        try {
            citaService.guardarCita(cita);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "citas/crear";
        }
        return "redirect:/citas/lista";
    }

    @GetMapping("/lista")
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.obtenerCitas());
        return "citas/lista";
    }
}
