package pl.danielkacprzak.spring0.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(int id) {
        super("Teacher with id " + id + " not found");
    }

}
