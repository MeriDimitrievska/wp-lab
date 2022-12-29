//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.model.Student;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CourseRepository {
//  public List<Course> findAllCourses()
//  {
//      return DataHolder.courses;
//  }
//
//  public Optional<Course> findById(Long courseId)
//  {
//      return DataHolder.courses.stream()
//              .filter(c->c.courseId.equals(courseId))
//              .findFirst();
//  }
//
//  public  List<Student> findAllStudentsByCourse(Long courseId)
//  {
//      List<Student> students=new ArrayList<>();
//      for(int i=0; i<DataHolder.courses.size(); i++)
//      {
//          if(DataHolder.courses.get(i).courseId.equals(courseId))
//          {
//              students=DataHolder.courses.get(i).students;
//              break;
//          }
//      }
//      return students;
//  }
//
//  public Course addStudentToCourse(Student student, Course course)
//  {
//      DataHolder.courses.removeIf(c->c.courseId.equals(course.courseId));
//      course.students.add(student);
//      DataHolder.courses.add(course);
//      return course;
//  }
//
//  public void addDateToCourse(Date date, Course course)
//  {
//      Optional<Course> course1=DataHolder.courses.stream().filter(i->i.name.equals(course.name)).findFirst();
//      course1.ifPresent(value -> value.date = date);
//  }
//}
