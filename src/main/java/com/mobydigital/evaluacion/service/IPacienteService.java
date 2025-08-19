package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    public Paciente savePaciente(Paciente paciente);

    public Paciente findPaciente(Long id);

    public List<Paciente> getPacientes();

    public void deletePaciente(Long id);


}
