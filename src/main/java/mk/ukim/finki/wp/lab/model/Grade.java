package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Character grade;
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public Grade(Character grade, Student student, Course course, LocalDateTime timestamp) {
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.timestamp = timestamp;
    }

    public Grade() {
    }
}
