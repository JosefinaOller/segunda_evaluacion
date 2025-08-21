package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.repository.IProfesionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalService implements IProfesionalService{

    @Autowired
    private IProfesionalRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ProfesionalService.class);

    @Override
    public Profesional saveProfesional(Profesional profesional) {
        logger.info("Guardando el profesiona con nombre completo: {}", profesional.getNombreCompleto());
        return repository.save(profesional);
    }

    @Override
    public List<Profesional> findByEspecialidad(String especialidad) {
        return repository.findByEspecialidadIgnoreCase(especialidad);
    }
}
