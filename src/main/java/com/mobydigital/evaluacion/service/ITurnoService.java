package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.dto.TurnoDto;
import com.mobydigital.evaluacion.model.Turno;
import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public TurnoDto saveTurno (Turno turno);

    public List<TurnoDto> getTurnos();

    public List<TurnoDto> findByFecha(LocalDate fecha);

    public List<TurnoDto> findByFechaBetween(LocalDate desde, LocalDate hasta);

    public void deleteTurno (Long id);
}
