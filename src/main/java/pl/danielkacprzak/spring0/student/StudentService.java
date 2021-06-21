package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student create(Student student) {
       return repository.save(student);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

}
