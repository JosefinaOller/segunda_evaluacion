package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }
}
