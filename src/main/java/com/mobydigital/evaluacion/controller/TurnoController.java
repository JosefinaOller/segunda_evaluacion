package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.dto.TurnoDto;
import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.service.ITurnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurnoDto createTurno(@Valid @RequestBody Turno turno){
        return service.saveTurno(turno);
    }

    @GetMapping
    public List<TurnoDto> getTurnos(){
        return service.getTurnos();
    }

    @GetMapping("fecha/{fecha}")
    public List<TurnoDto> findByFecha(@PathVariable LocalDate fecha){
        return service.findByFecha(fecha);
    }

    @GetMapping(params = {"desde","hasta"})
    public List<TurnoDto> findByFechaBetween(@RequestParam("desde") LocalDate desde, @RequestParam("hasta") LocalDate hasta){
        return service.findByFechaBetween(desde,hasta);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTurno(@PathVariable Long id){
        service.deleteTurno(id);
    }

}
