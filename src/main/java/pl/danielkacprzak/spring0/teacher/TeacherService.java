package pl.danielkacprzak.spring0.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public void deleteTeacher(Integer id) {
        repository.deleteById(id);
    }


}
