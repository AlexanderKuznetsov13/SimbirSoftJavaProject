package ru.alex.kuznetsov.project.simbirsoft.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnfinishedTaskException  extends RuntimeException {
        public UnfinishedTaskException() {
        }

        public UnfinishedTaskException(String message) {
                super(message);
        }

        public UnfinishedTaskException (Throwable cause) {
                super (cause);
        }

        public UnfinishedTaskException (String message, Throwable cause) {
                super (message, cause);
        }
}
