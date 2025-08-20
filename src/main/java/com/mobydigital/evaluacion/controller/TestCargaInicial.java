package com.mobydigital.evaluacion.controller;

import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import com.mobydigital.evaluacion.repository.IProfesionalRepository;
import com.mobydigital.evaluacion.repository.ITurnoRepository;
import com.mobydigital.evaluacion.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestCargaInicial implements CommandLineRunner {

    @Autowired
    private IProfesionalRepository profesionalRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private ITurnoRepository turnoRepository;

    private static final Logger logger = LoggerFactory.getLogger(TestCargaInicial.class);
    @Override
    public void run(String... args) throws Exception {

        logger.info("Cargando datos iniciales");
        //Crear pacientes
        Paciente pac1 = new Paciente(null,"Mariana","Lopez","14785296","marianalopez@hotmail.com");
        Paciente pac2 = new Paciente(null,"Santiago","Fernandez","40963258","santiagofernandez@gmail.com");
        pacienteRepository.save(pac1);
        pacienteRepository.save(pac2);
        //Crear profesionales
        Profesional prof1 = new Profesional(null,"Ana Belen Hernando", "Clinica");
        Profesional prof2 = new Profesional(null,"Felipe Villani","Odontologia");
        profesionalRepository.save(prof1);
        profesionalRepository.save(prof2);
        //Registrar turnos
        turnoRepository.save(new Turno(null,pac1,prof1, LocalDate.of(2025,6,20)));
        turnoRepository.save(new Turno(null,pac1,prof1, LocalDate.of(2025,7,20)));

        turnoRepository.save(new Turno(null,pac1,prof1, LocalDate.of(2025,8,20)));
        turnoRepository.save(new Turno(null,pac1,prof2, LocalDate.of(2025,8,20)));
        turnoRepository.save(new Turno(null,pac2,prof1, LocalDate.of(2025,8,20)));
        turnoRepository.save(new Turno(null,pac2,prof2, LocalDate.of(2025,8,20)));

        turnoRepository.save(new Turno(null,pac2,prof1, LocalDate.of(2025,5,19)));
        turnoRepository.save(new Turno(null,pac2,prof1, LocalDate.of(2025,7,30)));

        turnoRepository.save(new Turno(null,pac1,prof2, LocalDate.of(2025,4,7)));
        turnoRepository.save(new Turno(null,pac1,prof2, LocalDate.of(2025,6,4)));

        turnoRepository.save(new Turno(null,pac2,prof2, LocalDate.of(2025,3,3)));
        turnoRepository.save(new Turno(null,pac2,prof2, LocalDate.of(2025,4,9)));
        turnoRepository.save(new Turno(null,pac2,prof2, LocalDate.of(2025,6,15)));

        logger.info("Datos iniciales cargados");

    }
}
