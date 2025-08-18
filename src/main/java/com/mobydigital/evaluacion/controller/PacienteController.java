package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente createPaciente (@RequestBody Paciente paciente){
        return pacService.savePaciente(paciente);
    }

    @GetMapping ("{id}")
    public Paciente findPaciente (@PathVariable Long id){
        return pacService.findPaciente(id);
    }

    @GetMapping
    public List<Paciente> getPacientes(){
        return pacService.getPacientes();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaciente (@PathVariable Long id){
        pacService.deletePaciente(id);
    }

}
