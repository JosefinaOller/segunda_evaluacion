package com.mobydigital.evaluacion.exception;

public class TurnoExistenteException extends RuntimeException{
    public TurnoExistenteException(String mensaje){
        super(mensaje);
    }
}
