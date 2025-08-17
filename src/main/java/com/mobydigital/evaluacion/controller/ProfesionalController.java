package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.service.IProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    @Autowired
    private IProfesionalService profService;

    @PostMapping
    public String createProfesional(Profesional profesional){
        profService.saveProfesional(profesional);
        return "El profesional fue creado correctamente";
    }

    @GetMapping
    public List<Profesional> findByEspecialidad(@RequestParam(required = false) String especialidad){
        return profService.findByEspecialidad(especialidad);
    }

}
