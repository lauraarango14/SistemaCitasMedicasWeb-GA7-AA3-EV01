package com.citamedicas.sistemacitasmedicasweb.controller;

import com.citamedicas.sistemacitasmedicasweb.modelo.Paciente;
import com.citamedicas.sistemacitasmedicasweb.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Listar pacientes
    @GetMapping("/pacientes")
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "pacientes";
    }

    // Mostrar formulario para registrar paciente
    @GetMapping("/nuevo")
    public String nuevoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "formularioPaciente";
    }

    // Guardar paciente
    @PostMapping("/guardar")
    public String guardarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }

    // Mostrar formulario para editar
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable Long id, Model model) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Paciente no encontrado: " + id));

        model.addAttribute("paciente", paciente);

        return "formularioPaciente";
    }

    // Eliminar paciente
    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {

        pacienteRepository.deleteById(id);

        return "redirect:/pacientes";
    }
}