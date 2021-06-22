package pl.danielkacprzak.spring0.lesson;

import lombok.Data;
import lombok.RequiredArgsConstructor;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(nullable = false)
    private LocalDateTime dateTime;
}
