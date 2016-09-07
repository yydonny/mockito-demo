package demo.service.session;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SessionManagerFactory {
  private static ConcurrentMap<String, SessionManager> cache = new ConcurrentHashMap<>();
  public synchronized static SessionManager get(String name, Properties config) {
    return cache.putIfAbsent(name, new SessionManager(config));
  }

  public synchronized static SessionManager get(String name) {
    return cache.get(name);
  }

  public synchronized static void closeManager(String name) {
    cache.remove(name);
  }

}
