package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Profesional;

import java.util.List;

public interface IProfesionalService {

    public void saveProfesional(Profesional profesional);

    public List<Profesional> findByEspecialidad (String especialidad);
}
