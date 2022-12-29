package mk.ukim.finki.wp.lab.repository.impl;

//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Repository
public class SessionRepository {

    public void addSession(HttpSession session)
    {

    }

    public int getNumSessions()
    {
        return 1;
    }
}
