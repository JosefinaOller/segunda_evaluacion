package com.mobydigital.evaluacion.model;

import jakarta.persistence.*;
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
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profesiona_id")
    private Profesional profesional;

    private LocalDate fecha;
}
