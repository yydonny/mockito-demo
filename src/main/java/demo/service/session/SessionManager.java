package demo.service.session;

import java.util.Properties;

public class SessionManager {
  private final Properties config = new Properties();
  SessionManager(Properties _c) {
    config.putAll(_c);
  }
  public Session createSession(String name) {
    return new Session(name);
  }
}
