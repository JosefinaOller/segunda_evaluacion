package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.exception.RecursoNoEncontradoException;
import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository repository;

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("El paciente con ID " + id + " no existe."));
    }

    @Override
    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    @Override
    public void deletePaciente(Long id) {
        this.findPaciente(id); //Aprovecho el método y si se lanza la excepción, se corta acá!
        repository.deleteById(id);
    }
}
