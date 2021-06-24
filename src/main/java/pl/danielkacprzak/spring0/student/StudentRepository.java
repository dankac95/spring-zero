package pl.danielkacprzak.spring0.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("FROM Student s WHERE s.teacher.id = :teacherId") // HQL / JPAQL (Hibernate Query Language lub JPA Query Language)
    List<Student> findByTeacherId(@Param("teacherId") int teacherId);
}
