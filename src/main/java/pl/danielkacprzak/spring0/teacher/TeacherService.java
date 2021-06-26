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
        return repository.findAllActive();
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        teacher.setActive(false);
        repository.save(teacher);
    }
}