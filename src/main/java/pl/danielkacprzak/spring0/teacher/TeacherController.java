package pl.danielkacprzak.spring0.teacher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public String teacherListForm() {
        return "teacher-list";
    }

//    @GetMapping("/list")
//    public List<Teacher> showList() {
//        return service.showList();
//    }
}
