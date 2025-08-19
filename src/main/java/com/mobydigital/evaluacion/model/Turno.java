package com.mobydigital.evaluacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "paciente_id")
    @NotNull(message = "El paciente no debe ser nulo")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    @NotNull(message = "El profesional no debe ser nulo")
    private Profesional profesional;

    @NotNull(message = "La fecha no debe ser nula")
    private LocalDate fecha;
    
}
