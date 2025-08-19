package com.mobydigital.evaluacion.repository;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByFecha(LocalDate fecha);

    Optional<Turno> findByPacienteAndProfesionalAndFecha(Paciente paciente, Profesional profesional, LocalDate fecha);
}
