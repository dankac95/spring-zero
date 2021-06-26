package pl.danielkacprzak.spring0.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("FROM Teacher t WHERE t.active = true")
    List<Teacher> findAllActive();

    @Override
    @Query("FROM Teacher t WHERE t.id = :id AND t.active = true")
    Optional<Teacher> findById(@Param("id") Integer id);
}
