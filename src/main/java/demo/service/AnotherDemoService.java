package demo.service;

import demo.model.DemoDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class AnotherDemoService {

  @Value("demo.another.url")
  private String url;

  public DemoDocument loadJSON() {
    return new RestTemplate().getForObject(url, DemoDocument.class);
  }
}
