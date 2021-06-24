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

import java.util.List;

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
        return "lesson-create";
    }

    @PostMapping("/new")
    public String handleCreateLesson(@ModelAttribute Lesson lesson) {
        lessonService.createLesson(lesson);
        return "redirect:/lesson/list";
    }

    @GetMapping("/list")
    public String lessonListForm(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);
        return "lesson-list";
    }
}
