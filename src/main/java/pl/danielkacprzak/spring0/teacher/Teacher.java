package pl.danielkacprzak.spring0.teacher;

import jdk.jfr.BooleanFlag;
import lombok.*;
import pl.danielkacprzak.spring0.lesson.Lesson;
import pl.danielkacprzak.spring0.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@RequiredArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private boolean active = true;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "teacher")
    private List<Student> students;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "teacher")
    private List<Lesson> lessons;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
