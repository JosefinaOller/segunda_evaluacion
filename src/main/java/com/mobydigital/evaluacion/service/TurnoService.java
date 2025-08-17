package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepo;
    @Override
    public void saveTurno(Turno turno) {
        turnoRepo.save(turno);
    }
    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public List<Turno> findByFecha(LocalDate fecha) {
        return turnoRepo.findByFecha(fecha);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }
}
