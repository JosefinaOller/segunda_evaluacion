package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacService;

    @PostMapping
    public String createPaciente (@RequestBody Paciente paciente){
        pacService.savePaciente(paciente);
        return "El paciente fue creado correctamente";
    }

    @GetMapping ("{id}")
    public Paciente findPaciente (@PathVariable Long id){
        return pacService.findPaciente(id);
    }


}
