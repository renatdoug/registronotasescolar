package com.controlenota.srnota.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String string){
        super(string);
    }

}
