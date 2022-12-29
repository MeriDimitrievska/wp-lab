package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
//import mk.ukim.finki.wp.lab.repository.impl.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepositoryJpa studentRepository;

    public StudentServiceImpl(StudentRepositoryJpa studentRepository)
    {
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text, text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return studentRepository.save(new Student(username, password, name, surname));
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
