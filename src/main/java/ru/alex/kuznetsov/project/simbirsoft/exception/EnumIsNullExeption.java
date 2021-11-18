package ru.alex.kuznetsov.project.simbirsoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnumIsNullExeption extends RuntimeException{
    public EnumIsNullExeption(){
    }
    public EnumIsNullExeption(String message) {super(message);
    }
}
