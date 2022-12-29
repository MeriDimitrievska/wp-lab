package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = TeacherFullNameConverter.class)
    private TeacherFullName fullName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfEmployment;


    public Teacher() {
    }

    public Teacher(String s) {
    }

    public Teacher(TeacherFullName fullName, LocalDate date) {
        this.fullName=fullName;
        this.dateOfEmployment=date;
    }
}
