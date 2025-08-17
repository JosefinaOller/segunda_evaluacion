package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public void saveTurno (Turno turno);

    public List<Turno> getTurnos();

    public List<Turno> findByFecha(LocalDate fecha);

    public void deleteTurno (Long id);
}
