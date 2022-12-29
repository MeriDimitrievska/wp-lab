package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CourseService{
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    List<Course> listAll();
    Optional<Course> findById(long id);
    Course save(String name, String description, Teacher teacher, Date date);
    void delete(Long id);
    void deleteByName(String name);
}
