package ru.alex.kuznetsov.project.simbirsoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoEnumExeption extends RuntimeException{

    public NoEnumExeption(){

    }
    public NoEnumExeption(String message){super(message);}

}
