package com.project.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{
    
    public UserFoundException(){
        super("Usuario já existe");
    }
}
