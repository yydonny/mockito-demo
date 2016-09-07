package demo.service;

import demo.model.DemoDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Component
public class DemoService {
  public static final String SQL = "" +
      "insert into " +
      "nights_watch (first_name, last_name) " +
      "values (?, ?)";

  @Autowired RestTemplate restTemplate;
  @Autowired JdbcTemplate jdbcTemplate;

  public DemoDocument loadJSON() {
    return restTemplate
        .exchange("http://httpbin.org/get", GET, null, DemoDocument.class)
        .getBody();
  }

  public void insertData(String... fullName) {
    jdbcTemplate.update(SQL, (String[]) fullName);
  }
}
