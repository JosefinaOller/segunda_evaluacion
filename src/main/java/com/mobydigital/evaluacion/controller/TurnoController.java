package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public String createTurno(@RequestBody Turno turno){
        turnoService.saveTurno(turno);
        return "El turno fue creado correctamente";
    }

    @GetMapping
    public List<Turno> getTurnos(){
        return turnoService.getTurnos();
    }

    @GetMapping("fecha/{fecha}")
    public List<Turno> findByFecha(@PathVariable LocalDate fecha){
        return turnoService.findByFecha(fecha);
    }

}
