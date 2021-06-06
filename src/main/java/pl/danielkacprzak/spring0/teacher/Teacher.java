package pl.danielkacprzak.spring0.teacher;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}
