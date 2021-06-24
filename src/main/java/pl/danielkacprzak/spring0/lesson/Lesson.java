package pl.danielkacprzak.spring0.lesson;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.danielkacprzak.spring0.student.Student;
import pl.danielkacprzak.spring0.teacher.Teacher;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lesson")
@RequiredArgsConstructor
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
}
