package pl.danielkacprzak.spring0.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.danielkacprzak.spring0.student.StudentService;
import pl.danielkacprzak.spring0.teacher.TeacherService;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping("/new")
    public String lessonCreateForm(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "lesson-create";
    }

    @PostMapping("/new")
    public String handleCreateLesson(@ModelAttribute Lesson lesson) {
        lessonService.createLesson(lesson);
        return "redirect:/teacher/list";

    }
}
