package com.mobydigital.evaluacion.repository;

import com.mobydigital.evaluacion.model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesionalRepository extends JpaRepository<Profesional, Long> {
    List<Profesional> findByEspecialidadIgnoreCase(String especialidad);
}
