package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.repository.IProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalService implements IProfesionalService{

    @Autowired
    private IProfesionalRepository repository;

    @Override
    public Profesional saveProfesional(Profesional profesional) {
        return repository.save(profesional);
    }

    @Override
    public List<Profesional> findByEspecialidad(String especialidad) {
        return repository.findByEspecialidad(especialidad);
    }
}
