package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public String createTurno(Turno turno){
        turnoService.saveTurno(turno);
        return "El turno fue creado correctamente";
    }

    @GetMapping
    public List<Turno> getTurnos(){
        return turnoService.getTurnos();
    }
    
}
