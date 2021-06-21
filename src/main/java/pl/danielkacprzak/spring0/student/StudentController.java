package pl.danielkacprzak.spring0.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.danielkacprzak.spring0.teacher.TeacherService;

import java.util.List;

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
}
