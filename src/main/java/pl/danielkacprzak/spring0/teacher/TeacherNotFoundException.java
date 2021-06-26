package pl.danielkacprzak.spring0.teacher;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(int id) {
        super("Teacher with id " + id + " not found");
    }

}
