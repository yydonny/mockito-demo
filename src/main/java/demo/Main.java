package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {
  public static void main(String... args) {
    SpringApplication.run(Main.class);
  }

  @Bean
  RestTemplate restTemplate() { return new RestTemplate(); }

  @Bean
  JdbcTemplate jdbcTemplate() { return new JdbcTemplate(); }

}
