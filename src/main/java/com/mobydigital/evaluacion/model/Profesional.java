package com.mobydigital.evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre completo no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre completo debe tener entre 3 y 50 caracteres.")
    private String nombreCompleto;

    @NotBlank(message = "La especialidad no puede estar vacía.")
    @Size(min = 3, max = 20, message = "La especialidad debe tener entre 3 y 20 caracteres.")
    private String especialidad;
}
