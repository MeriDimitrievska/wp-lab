package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepositoryJpa extends JpaRepository<Course, Long> {
    void deleteByName(String name);
    Optional<Course> findByName(String name);
}
