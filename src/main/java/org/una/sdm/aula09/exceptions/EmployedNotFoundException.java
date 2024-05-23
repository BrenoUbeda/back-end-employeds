package org.una.sdm.aula09.exceptions;

public class EmployedNotFoundException extends RuntimeException {

    public EmployedNotFoundException(String mensagem) {
        super(mensagem);
    }

    public EmployedNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
