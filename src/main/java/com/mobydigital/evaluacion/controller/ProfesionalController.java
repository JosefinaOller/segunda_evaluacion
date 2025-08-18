package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.service.IProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    @Autowired
    private IProfesionalService profService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesional createProfesional(@RequestBody Profesional profesional){
        return profService.saveProfesional(profesional);
    }

    @GetMapping
    public List<Profesional> findByEspecialidad(@RequestParam(required = false) String especialidad){
        return profService.findByEspecialidad(especialidad);
    }

}
