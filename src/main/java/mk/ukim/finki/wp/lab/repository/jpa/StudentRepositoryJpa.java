package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {
    List<Student> findAllByNameOrSurname(String text, String text1);
    Student findByUsername(String username);
}
