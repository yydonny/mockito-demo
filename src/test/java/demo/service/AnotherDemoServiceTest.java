package demo.service;

import demo.model.DemoDocument;
import demo.service.session.AnotherDemoService;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.client.RestTemplate;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.fail;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.expectNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ // For class-level mocking, put all the testees and collaborators here
    RestTemplate.class,
    AnotherDemoService.class })
public class AnotherDemoServiceTest {
  AnotherDemoService testee = new AnotherDemoService();

  @Test
  public void test1() {
    DemoDocument value = new DemoDocument();

    // Mock the constructor
    RestTemplate restTemplate = createMock(RestTemplate.class);
    try {
      expectNew(RestTemplate.class).andReturn(restTemplate);
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }

    // declare expected interactions
    expect(restTemplate.getForObject(anyString(), EasyMock.<Class<DemoDocument>>anyObject()))
        .andReturn(value).times(1);

    // Activate the mock
    PowerMock.replay(restTemplate, RestTemplate.class); // use PowerMock.replay(), not EasyMock.replay()
    testee.loadJSON();

    // Verify the expectation
    PowerMock.verify(restTemplate, RestTemplate.class); // use PowerMock.verify(), not EasyMock.verify()
  }
}
