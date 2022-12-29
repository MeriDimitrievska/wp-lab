package mk.ukim.finki.wp.lab.web.controller;

//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService=teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model)
    {

        model.addAttribute("allCourses", courseService.listAll().stream()
                .sorted(Comparator.comparing(i->i.name)).collect(Collectors.toList()));
      //  model.addAttribute("sessions", 0);
        return "listCourses";
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveOrEdit(Model model)
    {
        model.addAttribute("teachers", teacherService.findAll());
        return "add-course";
    }

    @PostMapping("/addCourse")
    public String saveCourse(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long id,
                             @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) throws ParseException {
//        DataHolder.courses.removeIf(i->i.name.equals(name));
//        Optional<Teacher> teacher=DataHolder.teachers.stream().filter(i->i.getId().equals(id)).findFirst();
//        if(teacher.isPresent())
//        {
//            Course course=new Course(name, description, teacher.get(), date);
//            DataHolder.courses.add(course);
//            return "redirect:/courses";
//        }
//        return "redirect:/courses";
        Optional<Teacher> teacher=teacherService.findById(id);
        if(teacher.isPresent())
        {
            courseService.deleteByName(name);
            Course c=courseService.save(name, description, teacher.get(), date);
            return "redirect:/courses";
        }
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCourse(@PathVariable Long id)
    {
        courseService.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editCourse(@PathVariable Long id, Model model)
    {
        if(this.courseService.findById(id).isPresent())
        {
            Course course= courseService.findById(id).get();
            model.addAttribute("course", course);
            model.addAttribute("teachers", teacherService.findAll());
            model.addAttribute("pickDate", course.date);
            return "add-course";
        }
        return "redirect:/courses";
    }
}
