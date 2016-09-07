package demo.service;

import demo.model.DemoDocument;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.GET;

@RunWith(MockitoJUnitRunner.class)
public class DemoServiceTest {

  @Spy
  @InjectMocks
  DemoService testee = new DemoService();

  @Mock
  RestTemplate restTemplate;

  @Mock
  JdbcTemplate jdbcTemplate;

  @Test
  public void test1() {
    DemoDocument doc = new DemoDocument();
    ResponseEntity<DemoDocument> mockResponse = new ResponseEntity<>(doc, HttpStatus.OK);
    when(restTemplate.exchange(
        anyString(),
        eq(GET),
        anyObject(),
        eq(DemoDocument.class)
    )).thenReturn(mockResponse);
    Assert.assertSame(doc, testee.loadJSON());
  }

  @Test
  public void test2() {
    testee.insertData("Jon", "Snow");
    verify(jdbcTemplate, times(1))
        .update(eq(DemoService.SQL), eq("Jon"), eq("Snow"));
  }
}
