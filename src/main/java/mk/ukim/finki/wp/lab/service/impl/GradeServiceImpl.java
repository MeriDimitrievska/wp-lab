package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepositoryJpa;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepositoryJpa gradeRepositoryJpa;

    public GradeServiceImpl(GradeRepositoryJpa gradeRepositoryJpa) {
        this.gradeRepositoryJpa = gradeRepositoryJpa;
    }

    @Override
    public Character gradeByStudentAndCourse(Student student, Course course) {
        return gradeRepositoryJpa.findByCourseAndStudent(course, student);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepositoryJpa.findAll();
    }

    @Override
    public void addGradeToStudent(Student student, Course course, Character grade, LocalDateTime date) {
        Grade grade1=new Grade(grade, student, course, date);
        gradeRepositoryJpa.save(grade1);
    }


}
