package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.exception.RecursoNoEncontradoException;
import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(PacienteService.class);

    @Override
    public Paciente savePaciente(Paciente paciente) {
        logger.info("Guardando el paciente con DNI: {}", paciente.getDni());
        return repository.save(paciente);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            logger.error("No se encontró el paciente con ID: {}",id);
            return new RecursoNoEncontradoException("El paciente con ID " + id + " no existe.");
        });
    }

    @Override
    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    @Override
    public void deletePaciente(Long id) {
        this.findPaciente(id); //Aprovecho el método y si se lanza la excepción, se corta acá!
        logger.info("Eliminando paciente con ID: {}", id);
        repository.deleteById(id);
    }
}
