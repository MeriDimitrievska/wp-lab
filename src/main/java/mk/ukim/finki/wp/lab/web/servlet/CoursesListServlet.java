package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.SessionService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "courseListServlet", urlPatterns = "/listCourses")
public class CoursesListServlet extends HttpServlet {
    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;
    private final SessionService sessionService;

    public CoursesListServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine, SessionService sessionService)
    {
        this.courseService=courseService;
        this.springTemplateEngine=springTemplateEngine;
        this.sessionService=sessionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("allCourses", courseService.listAll());
        webContext.setVariable("sessions", sessionService.getNumSessions());
        resp.setContentType("text/html");
        springTemplateEngine.process("listCourses.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id=Long.parseLong(req.getParameter("courseId"));
        req.getSession().setAttribute("courseId", id);
        sessionService.addSession(req.getSession());
        req.getSession().setAttribute("courseFilter", courseService.findById(id));
        req.setAttribute("id", id);
        resp.sendRedirect("/AddStudent");
    }
}
