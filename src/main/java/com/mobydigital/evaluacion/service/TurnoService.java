package com.mobydigital.evaluacion.service;

import com.mobydigital.evaluacion.dto.TurnoDTO;
import com.mobydigital.evaluacion.exception.TurnoExistenteException;
import com.mobydigital.evaluacion.exception.RecursoNoEncontradoException;
import com.mobydigital.evaluacion.model.Paciente;
import com.mobydigital.evaluacion.model.Profesional;
import com.mobydigital.evaluacion.model.Turno;
import com.mobydigital.evaluacion.repository.IPacienteRepository;
import com.mobydigital.evaluacion.repository.IProfesionalRepository;
import com.mobydigital.evaluacion.repository.ITurnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IProfesionalRepository profesionalRepository;

    private static final Logger logger = LoggerFactory.getLogger(TurnoService.class);
    @Override
    public TurnoDTO saveTurno(Turno turno) {

        //Validar si existe Paciente
        Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId()).orElseThrow(() ->
        {
            logger.error("No existe el paciente buscado con ID: {}", turno.getPaciente().getId());
            return new RecursoNoEncontradoException("El paciente con ID " + turno.getPaciente().getId() + " no existe.");
        });

        //Validar si existe Profesional
        Profesional profesional = profesionalRepository.findById(turno.getProfesional().getId()).orElseThrow(() ->
        {
            logger.error("No existe el profesional buscado con ID: {}", turno.getProfesional().getId());
            return new RecursoNoEncontradoException("El profesional con ID " + turno.getProfesional().getId() + " no existe.");
        });

        //Validar que no haya duplicados
        if (turnoRepository.findByPacienteAndProfesionalAndFecha(paciente,profesional,turno.getFecha()).isPresent()) {
            logger.error("Se intenta duplicar un turno, para el paciente {} {}",paciente.getNombre(), paciente.getApellido());
            throw new TurnoExistenteException("Ya existe un turno para el mismo paciente, profesional y fecha. ");
        }
        turno.setPaciente(paciente);
        turno.setProfesional(profesional);

        Turno nuevoTurno = turnoRepository.save(turno);
        logger.info("Guardando el turno con ID: {}", nuevoTurno.getId());
        //Convertir Turno en DTO
        return convertToDto(nuevoTurno);
    }
    @Override
    public List<TurnoDTO> getTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TurnoDTO> findByFecha(LocalDate fecha) {
        List<Turno> turnos = turnoRepository.findByFecha(fecha);
        return turnos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TurnoDTO> findByFechaBetween(LocalDate desde, LocalDate hasta) {
        List<Turno> turnos = turnoRepository.findByFechaBetween(desde,hasta);
        return turnos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTurno(Long id) {
        if (!turnoRepository.existsById(id)) { //Verifico si no existe el turno buscado
            logger.error("El turno con ID: {} no existe para eliminar ", id);
            throw new RecursoNoEncontradoException("El turno con ID " + id + " no existe. ");
        }
        logger.info("Eliminando el turno con ID: {}",id);
        turnoRepository.deleteById(id);
    }

    private TurnoDTO convertToDto(Turno turno){ //hago esto para no duplicar el código de conversión de turno a turnoDTO.
        return new TurnoDTO(
                turno.getId(),
                turno.getPaciente().getNombre() + " " + turno.getPaciente().getApellido(), //hago asi para tener nombre completo
                turno.getProfesional().getNombreCompleto(),
                turno.getProfesional().getEspecialidad(),
                turno.getFecha());
    }
}
