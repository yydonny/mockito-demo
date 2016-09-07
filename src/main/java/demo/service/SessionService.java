package demo.service;

import demo.service.session.SessionManagerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class SessionService {

  private static final String SESSION_NAME = "users";
  public void initSession(String key, String value) {
    SessionManagerFactory
        .get(SESSION_NAME, new Properties())
        .createSession(SESSION_NAME)
        .put(key, value);
  }

}
