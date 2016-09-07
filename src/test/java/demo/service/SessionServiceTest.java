package demo.service;

import demo.service.session.Session;
import demo.service.session.SessionManager;
import demo.service.session.SessionManagerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Properties;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SessionManagerFactory.class })
public class SessionServiceTest {
  @Mock
  SessionManager sessionManager;
  @Mock
  Session session;

  SessionService testee = new SessionService();

  @Test
  public void test1() {
    mockStatic(SessionManagerFactory.class);

    when(SessionManagerFactory.get(anyString(), any(Properties.class)))
        .thenReturn(sessionManager);
    when(sessionManager.createSession(anyString())).thenReturn(session);
    testee.initSession("a", "b");
    verify(session, times(1)).put(eq("a"), eq("b"));
  }
}
