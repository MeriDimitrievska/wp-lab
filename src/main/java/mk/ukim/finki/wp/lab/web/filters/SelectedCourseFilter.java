package mk.ukim.finki.wp.lab.web.filters;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.CourseService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

//@WebFilter
public class SelectedCourseFilter  implements Filter {
    private final CourseService courseService;

    public SelectedCourseFilter(CourseService courseService)
    {
        this.courseService=courseService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String path=request.getServletPath();
        String method=request.getMethod();
        Long id=(Long)request.getSession().getAttribute("courseId");
       if(id==null && !path.equals("/courses"))
            response.sendRedirect("/courses");
        else filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
