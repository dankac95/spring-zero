package pl.danielkacprzak.spring0.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.danielkacprzak.spring0.exceptions.TeacherNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class TeacherErrorServiceAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({TeacherNotFoundException.class})
    public void handle(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
