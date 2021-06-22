package pl.danielkacprzak.spring0.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository repository;

    public Lesson createLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    public List<Lesson> findAll() {
        return repository.findAll();
    }
}
