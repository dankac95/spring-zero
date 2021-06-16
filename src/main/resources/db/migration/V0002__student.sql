CREATE TABLE student
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    teacher_id INT          NOT NULL,
    FOREIGN KEY FK_student_teacher (teacher_id) REFERENCES teacher (id)
);