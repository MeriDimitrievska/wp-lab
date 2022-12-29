package mk.ukim.finki.wp.lab.service;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public interface SessionService {
    void addSession(HttpSession session);
    int getNumSessions();
}
