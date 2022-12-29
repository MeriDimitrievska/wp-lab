package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.GradeService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "enrolment", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    private final StudentService studentService;
    private final GradeService gradeService;

    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine, CourseService courseService, StudentService studentService, GradeService gradeService)
    {
        this.springTemplateEngine=springTemplateEngine;
        this.courseService=courseService;
        this.studentService=studentService;
        this.gradeService=gradeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req, resp, req.getServletContext());
        Long id= (Long)  req.getSession().getAttribute("courseId");
        Optional<Course> course=courseService.findById(id);
        if(course.isPresent()) {
            webContext.setVariable("course", course.get());
            webContext.setVariable("allStudents", courseService.listStudentsByCourse(id));
            webContext.setVariable("grades", gradeService.findAll());
        }
        resp.setContentType("text/html");
        springTemplateEngine.process("studentsInCourse.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String location=req.getParameter("btn");
        if(location.equals("back"))
            resp.sendRedirect("/courses");
        else resp.sendRedirect("/grade");
    }
}
