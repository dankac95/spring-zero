package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void create(Student student) {
        repository.save(student);
    }
}
