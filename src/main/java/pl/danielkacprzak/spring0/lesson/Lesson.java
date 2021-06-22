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
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @Column(nullable = false)
    private LocalDateTime dateTime;
}
