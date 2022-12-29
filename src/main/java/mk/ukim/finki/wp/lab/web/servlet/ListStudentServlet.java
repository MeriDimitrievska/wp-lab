package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
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

@WebServlet(name = "listStudentServlet", urlPatterns = "/AddStudent")
public class ListStudentServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    private final StudentService studentService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine,StudentService studentService, CourseService courseService)
    {
        this.springTemplateEngine=springTemplateEngine;
        this.courseService=courseService;
        this.studentService=studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req, resp, req.getServletContext());
        //long id=(long)req.getSession().getAttribute("courseId");
        Student student=(Student) req.getSession().getAttribute("student");
//        List<Student> list=new ArrayList<>();
//        list=studentService.listAll();
//        if(student!=null)
//            list.add(student);
        webContext.setVariable("allStudents", studentService.listAll());
        resp.setContentType("text/html");
        springTemplateEngine.process("listStudents.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String location=req.getParameter("btn");
            if(location.equals("create"))
            {
                resp.sendRedirect("/CreateStudent");
            }
            else if(location.equals("submit"))
            {
                String params=req.getParameter("chosenStudent");
                Student student=studentService.findByUsername(params);
                if(student!=null)
                {
                    long id= (long) req.getSession().getAttribute("courseId");
                    Optional<Course> course=courseService.findById(id);
                    courseService.addStudentInCourse(params, id);
                }
                resp.sendRedirect("/StudentEnrollmentSummary");
            }
            else {
                resp.sendRedirect("/listCourses");
            }
    }
}
