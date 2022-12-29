package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.enums.Type;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long courseId;
    public String name;
    public String description;
    @ManyToMany( fetch=FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Student> students; //list of students that listen that course
    @ManyToOne( fetch=FetchType.LAZY) //EAGER
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Teacher teacher;
    public Date date;
    @Enumerated(EnumType.STRING)
    public Type type;

    public Course(String name, String description, List<Student> students, Teacher teacher, Type type){
       // this.courseId=(long) (Math.random()*1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher=teacher;
    }

    public Course(String name, String description, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public Course(String name, String description, Teacher teacher, Date date) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
        this.date = date;
    }

    public Course() {

    }

    public Course(String name, String description, List<Student> all, Teacher teacher, Date date) {
        this.name = name;
        this.description = description;
        this.students = all;
        this.teacher = teacher;
        this.date = date;
    }

    public Course(Long id,String name, String description) {
        this.name = name;
        this.description = description;
        this.courseId=id;
    }
}
