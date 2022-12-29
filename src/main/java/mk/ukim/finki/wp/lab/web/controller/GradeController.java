package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.GradeService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;
    private final CourseService courseService;
    private final StudentService studentService;

    public GradeController(GradeService gradeService, CourseService courseService, StudentService studentService) {
        this.gradeService = gradeService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping("/add/{courseId}/{username}")
    public String addGrade(@PathVariable long courseId, @PathVariable String username, @RequestParam String grade,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date)
    {
        Student student= studentService.findByUsername(username);
        Optional<Course> course=courseService.findById(courseId);
        if(course.isPresent())
        {
            gradeService.addGradeToStudent(student, course.get(), grade.charAt(0), date);
        }
        return "redirect:/courses";
    }

    @GetMapping("/{courseId}/{username}")
    public String getAddGradePage(@PathVariable long courseId, @PathVariable String username, Model model)
    {
        Student student= studentService.findByUsername(username);
        Optional<Course> course=courseService.findById(courseId);
        if(course.isPresent())
        {
            model.addAttribute("studentUsername", student.username);
            model.addAttribute("courseId", courseId);
            model.addAttribute("studentName", student.name);
            model.addAttribute("courseName", course.get().name);
        }
        return "add-grade";
    }
}
