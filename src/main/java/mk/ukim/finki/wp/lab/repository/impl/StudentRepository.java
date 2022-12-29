//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Student;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class StudentRepository {
//
//    public List<Student> findAllStudents()
//    {
//       return new ArrayList<>(DataHolder.students);
//    }
//
//    public List<Student> findAllByNameOrSurname(String text)
//    {
//        return DataHolder.students.stream()
//                .filter(s->s.name.contains(text)||s.surname.contains(text))
//                .collect(Collectors.toList());
//    }
//
//    public Student save(Student student)
//    {
//        DataHolder.students.removeIf(s->s.username.equals(student.username));
//        DataHolder.students.add(student);
//        return student;
//    }
//
//    public Student findByUsername(String username)
//    {
//        Optional<Student> student=DataHolder.students.stream()
//                .filter(s->s.username.equals(username))
//                .findFirst();
//        Student s1=null;
//        if(student.isPresent())
//            s1=student.get();
//        return s1;
//    }
//}
