package pl.danielkacprzak.spring0.student;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.danielkacprzak.spring0.teacher.Teacher;

import javax.persistence.*;

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
}
