package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exceptions.StudentOrCourseNotFound;
//import mk.ukim.finki.wp.lab.repository.impl.CourseRepository;
//import mk.ukim.finki.wp.lab.repository.impl.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepositoryJpa;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepositoryJpa courseRepository;
    private final StudentRepositoryJpa studentRepository;
    private final TeacherRepositoryJpa teacherRepositoryJpa;

    public CourseServiceImpl(CourseRepositoryJpa courseRepository, StudentRepositoryJpa studentRepository, TeacherRepositoryJpa teacherRepositoryJpa) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepositoryJpa = teacherRepositoryJpa;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
//        return courseRepository.findAllStudentsByCourse(courseId);
//       Optional<Course> course=courseRepository.findAll().stream().filter(i->i.courseId.equals(courseId))
//                .findFirst();
//        return course.map(value -> value.students).orElse(null);
        Optional<Course> course=courseRepository.findById(courseId);
        return course.map(value -> value.students).orElse(null);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student=studentRepository.findByUsername(username);
        Optional<Course> course=courseRepository.findById(courseId);
        if(student!=null && course.isPresent())
        {
            List<Student> all=course.get().students;
            all.add(student);
            courseRepository.delete(course.get());
            Course c1=new Course(course.get().name, course.get().description,all,  course.get().teacher, course.get().date);
            courseRepository.save(c1);
//            courseRepository.addStudentToCourse(student, course.get());
            return course.get();
        }
        else throw new StudentOrCourseNotFound();
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(String name, String description, Teacher teacher, Date date)
    {
        return courseRepository.save(new Course(name, description, teacher, date));
    }

    @Override
    public void delete(Long id) {
        Optional<Course> course=courseRepository.findById(id);
        course.ifPresent(courseRepository::delete);
    }

    @Override
    public void deleteByName(String name) {
        Optional<Course> course=courseRepository.findByName(name);
        if(course.isPresent()) courseRepository.delete(course.get());
        else throw new StudentOrCourseNotFound();
    }
}
