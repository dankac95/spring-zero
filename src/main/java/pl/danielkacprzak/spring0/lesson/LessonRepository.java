package pl.danielkacprzak.spring0.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.danielkacprzak.spring0.student.Student;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
