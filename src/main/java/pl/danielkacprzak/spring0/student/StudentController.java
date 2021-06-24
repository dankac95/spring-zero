package pl.danielkacprzak.spring0.student;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.danielkacprzak.spring0.exceptions.TeacherNotFoundException;
import pl.danielkacprzak.spring0.teacher.TeacherService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "student-create";
    }

    @PostMapping("/new")
    public String handleStudentCreateForm(@ModelAttribute Student student) {
        studentService.create(student);
        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String studentListForm(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping
    public List<StudentDto> listStudents(@RequestParam("teacherId") int teacherId) {
        // TODO: Throw HTTP 404 (Not Found) status when there is no teacher with given ID
        try {
            return studentService.findByTeacher(teacherId)
                    .stream()
                    .map(StudentDto::mapStudent)
                    .collect(Collectors.toList());
        } catch (TeacherNotFoundException e) {
            throw new TeacherNotFoundException(teacherId);
        }
    }
}