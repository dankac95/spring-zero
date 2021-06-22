package pl.danielkacprzak.spring0.student;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.danielkacprzak.spring0.lesson.Lesson;
import pl.danielkacprzak.spring0.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@RequiredArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lesson> lessons;
}
