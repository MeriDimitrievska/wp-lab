package mk.ukim.finki.wp.lab.web.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionServlet implements HttpSessionListener {
    private static int count=0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
    }

    public static int getCount() {
        return count;
    }
}
