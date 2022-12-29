package mk.ukim.finki.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="sessions", urlPatterns="/sessions")
public class SessionsNumberServlet extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;

    public SessionsNumberServlet(SpringTemplateEngine springTemplateEngine)
    {
        this.springTemplateEngine=springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req, resp, req.getServletContext());
        springTemplateEngine.process("numSessions", webContext, resp.getWriter());
    }
}
