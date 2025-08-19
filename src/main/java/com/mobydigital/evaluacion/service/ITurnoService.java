package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public Turno saveTurno (Turno turno);

    public List<Turno> getTurnos();

    public List<Turno> findByFecha(LocalDate fecha);

    public List<Turno> findByFechaBetween(LocalDate desde, LocalDate hasta);

    public void deleteTurno (Long id);
}
