package com.mobydigital.evaluacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TurnoDTO {

    private Long id;
    private String nombreCompletoPaciente;
    private String nombreCompletoProfesional;
    private String especialidadProfesional;
    private LocalDate fecha;

}

