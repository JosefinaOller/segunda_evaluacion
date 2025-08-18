package com.mobydigital.evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String nombre;

    @NotBlank
    @Size(min = 2, max = 30)
    private String apellido;

    @NotBlank
    @Size(min = 7, max = 8)
    @Pattern(regexp = "\\d+") //solo números
    private String dni;

    @NotBlank
    @Email
    private String email;
}
