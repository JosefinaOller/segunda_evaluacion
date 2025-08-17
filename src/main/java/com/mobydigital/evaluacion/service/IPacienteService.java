package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Paciente;

import java.util.List;

public interface IPacienteService {

    public void savePaciente(Paciente paciente);

    public Paciente findPaciente(Long id);

    public List<Paciente> getPacientes();

    public void deletePaciente(Long id);


}
