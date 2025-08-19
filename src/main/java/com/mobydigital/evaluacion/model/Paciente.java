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

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres.")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(min = 2, max = 30, message = "El apellido debe tener entre 2 y 30 caracteres.")
    private String apellido;

    @NotBlank(message = "El documento no puede estar vacío.")
    @Size(min = 7, max = 8, message = "El documento debe tener entre 7 y 8 números.")
    @Pattern(regexp = "\\d+", message = "El documento debe contener sólo números.") //solo números
    private String dni;

    @NotBlank(message = "El email no puede estar vacío.")
    @Email(message = "El email debe tener @ y su servidor correspondiente.")
    private String email;
}
