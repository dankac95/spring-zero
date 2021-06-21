package pl.danielkacprzak.spring0.teacher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @GetMapping("/new")
    public String teacherCreateForm() {
        return "teacher-create";
    }

    @PostMapping("/new")
    public String handleCreateTeacher(@ModelAttribute Teacher teacher) {
        log.info("Creating teacher = {}", teacher);
        service.create(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/list")
    public String teacherListForm(Model model) {
        List<Teacher> teachers = service.findAll();
        model.addAttribute("teachers", teachers); // pod nazwa teachers przekkazujemy do widoku kolekcje obiektow
        return "teacher-list";
    }

    @GetMapping("/delete")
    public String deleteTeacherForm() {
        return "teacher-delete";
    }

    @DeleteMapping("/delete")
    public void deleteTeacher(Integer id) {
        service.deleteTeacher(id);
    }
}
