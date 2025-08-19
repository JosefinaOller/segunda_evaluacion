package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.exception.DatoInvalidoException;
import com.mobydigital.evaluacion.exception.RecursoNoEncontradoException;
import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import com.mobydigital.evaluacion.repository.IProfesionalRepository;
import com.mobydigital.evaluacion.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IProfesionalRepository profesionalRepository;
    @Override
    public Turno saveTurno(Turno turno) {
        //Validar si existe Paciente
        Optional<Paciente> pacExistente = pacienteRepository.findById(turno.getPaciente().getId());
        if (pacExistente.isEmpty()) {
            throw new RecursoNoEncontradoException("El paciente con ID " + turno.getPaciente().getId() + " no existe.");
        }
        //Validar si existe Profesional
        Optional<Profesional> profExistente = profesionalRepository.findById(turno.getProfesional().getId());
        if (profExistente.isEmpty()) {
            throw new RecursoNoEncontradoException("El profesional con ID " + turno.getProfesional().getId() + " no existe.");
        }
        //Validar que no haya duplicados
        if (turnoRepository.findByPacienteAndProfesionalAndFecha(turno.getPaciente(),turno.getProfesional(),turno.getFecha()).isPresent()) {
            throw new DatoInvalidoException("Ya existe un turno para el mismo paciente, profesional y fecha. ");
        }

        return turnoRepository.save(turno);
    }
    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public List<Turno> findByFecha(LocalDate fecha) {
        return turnoRepository.findByFecha(fecha);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
