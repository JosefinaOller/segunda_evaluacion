package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.service.IProfesionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    @Autowired
    private IProfesionalService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesional createProfesional(@Valid @RequestBody Profesional profesional){
        return service.saveProfesional(profesional);
    }

    @GetMapping(params = "especialidad")
    public List<Profesional> findByEspecialidad(@RequestParam String especialidad){
        return service.findByEspecialidad(especialidad);
    }

}
