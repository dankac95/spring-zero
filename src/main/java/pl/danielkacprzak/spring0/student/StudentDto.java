package pl.danielkacprzak.spring0.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;

    public static StudentDto mapStudent(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName());
    }
}
