package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface GradeService {
    Character gradeByStudentAndCourse(Student student, Course course);
    List<Grade> findAll();
    void addGradeToStudent(Student student, Course course, Character grade, LocalDateTime date);
}
