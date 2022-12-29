package mk.ukim.finki.wp.lab.service.impl;

//import mk.ukim.finki.wp.lab.repository.impl.SessionRepository;
import mk.ukim.finki.wp.lab.repository.impl.SessionRepository;
import mk.ukim.finki.wp.lab.service.SessionService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository)
    {
        this.sessionRepository=sessionRepository;
    }

    @Override
    public void addSession(HttpSession session) {

    }

    @Override
    public int getNumSessions() {
        return 1;
    }
}
