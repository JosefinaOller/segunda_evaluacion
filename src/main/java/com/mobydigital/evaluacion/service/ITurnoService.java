package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.dto.TurnoDTO;
import com.mobydigital.evaluacion.model.Turno;
import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    public TurnoDTO saveTurno (Turno turno);

    public List<TurnoDTO> getTurnos();

    public List<TurnoDTO> findByFecha(LocalDate fecha);

    public List<TurnoDTO> findByFechaBetween(LocalDate desde, LocalDate hasta);

    public void deleteTurno (Long id);
}
