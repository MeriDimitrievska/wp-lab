package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.TeacherFullName;
import mk.ukim.finki.wp.lab.model.exceptions.StudentOrCourseNotFound;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepositoryJpa;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import mk.ukim.finki.wp.lab.service.impl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//Junit test za CourseService, method addStudentInCourse
@RunWith(MockitoJUnitRunner.class)
public class JUnitTest {
    @Mock
    private CourseRepositoryJpa courseRepository;

    @Mock
    private StudentRepositoryJpa studentRepository;

    @Mock
    private TeacherRepositoryJpa teacherService;

    private CourseService courseService;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        Course course=new Course(99L, "Bazi na podatoci", "SQL");
        Student student=new Student("ana", "ana", "Ana", "Anevska");
        Mockito.when(this.courseRepository.save(Mockito.any(Course.class))).thenReturn(course);
        this.courseService= Mockito.spy(new CourseServiceImpl(this.courseRepository, this.studentRepository, this.teacherService));
    }

    @Test
    public void studentFound()
    {
        Course course=courseService.addStudentInCourse("ana", 99L);
        Mockito.verify(this.courseService).addStudentInCourse("ana", 99L);
        Assert.assertNotNull("not found", course);
    }

    @Test
    public void studentNotFound()
    {
        Assert.assertThrows("StudentOrCourseNotFound expected",
                StudentOrCourseNotFound.class,
                () -> this.courseService.addStudentInCourse("meri123", 2L));
        Mockito.verify(this.courseService).addStudentInCourse("meri123", 2L);
    }
}
