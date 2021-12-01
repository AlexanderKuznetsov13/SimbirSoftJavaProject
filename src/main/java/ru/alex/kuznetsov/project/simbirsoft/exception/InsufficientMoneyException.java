package ru.alex.kuznetsov.project.simbirsoft.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientMoneyException extends RuntimeException {
        public InsufficientMoneyException() {
        }

        public InsufficientMoneyException(String message) {
                super(message);
        }

        public InsufficientMoneyException(Throwable cause) {
                super (cause);
        }

        public InsufficientMoneyException(String message, Throwable cause) {
                super (message, cause);
        }
}
