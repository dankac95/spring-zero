package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.danielkacprzak.spring0.teacher.Teacher;
import pl.danielkacprzak.spring0.teacher.TeacherNotFoundException;
import pl.danielkacprzak.spring0.teacher.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final TeacherRepository teacherRepository;

    public Student create(Student student) {
        return repository.save(student);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public List<Student> findByTeacher(int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));
        return teacher.getStudents();
    }
}
