package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.danielkacprzak.spring0.teacher.TeacherService;

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
    @ResponseBody
    public List<StudentDto> listStudents(@RequestParam("teacherId") int teacherId) {
        return studentService.findByTeacher(teacherId)
                .stream()
                .map(StudentDto::mapStudent)
                .collect(Collectors.toList());
    }
}


// trzeba odpiac ucznia od nauczyciela zeby moc go usunac a nastepnie dopiero testowac powysza metode
//https://dzone.com/articles/spring-rest-service-exception-handling-1
//https://springframework.guru/exception-handling-in-spring-boot-rest-api/
//https://mkyong.com/spring-boot/spring-rest-error-handling-example/