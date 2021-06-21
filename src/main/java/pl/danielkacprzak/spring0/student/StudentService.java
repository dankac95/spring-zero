package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void create(Student student) {
        repository.save(student);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }
}
