CREATE TABLE lesson
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    teacher_id      INT NOT NULL,
    FOREIGN KEY FK_lesson_teacher (teacher_id) REFERENCES teacher (id),
    student_id INT NOT NULL,
    FOREIGN KEY FK_lesson_student (student_id) REFERENCES student (id),
    date_time DATETIME NOT NULL
);