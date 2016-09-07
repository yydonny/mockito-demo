package demo.controller;

import demo.model.DemoDocument;
import demo.service.DemoService;
import demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

  @Autowired
  private DemoService demoService;
  private SessionService sessionService;

  @RequestMapping("/demo")
  public DemoDocument foo() { return demoService.loadJSON(); }

  @RequestMapping(path = "/demo", method = RequestMethod.PUT)
  public ResponseEntity<String> bar(String name) {
    sessionService.initSession("name", name);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
