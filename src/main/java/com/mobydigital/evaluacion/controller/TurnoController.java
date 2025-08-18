package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turno createTurno(@RequestBody Turno turno){
        return turnoService.saveTurno(turno);
    }

    @GetMapping
    public List<Turno> getTurnos(){
        return turnoService.getTurnos();
    }

    @GetMapping("fecha/{fecha}")
    public List<Turno> findByFecha(@PathVariable LocalDate fecha){
        return turnoService.findByFecha(fecha);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTurno(@PathVariable Long id){
        turnoService.deleteTurno(id);
    }

}
