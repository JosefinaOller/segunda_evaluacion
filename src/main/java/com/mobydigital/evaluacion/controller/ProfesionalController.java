package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.service.IProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
