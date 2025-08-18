package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.service.IPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente createPaciente (@Valid @RequestBody Paciente paciente){
        return service.savePaciente(paciente);
    }

    @GetMapping ("{id}")
    public Paciente findPaciente (@PathVariable Long id){
        return service.findPaciente(id);
    }

    @GetMapping
    public List<Paciente> getPacientes(){
        return service.getPacientes();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaciente (@PathVariable Long id){
        service.deletePaciente(id);
    }

}
