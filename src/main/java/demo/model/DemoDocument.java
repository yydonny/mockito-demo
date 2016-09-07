package demo.model;

import java.util.Map;

public class DemoDocument {
  private Map<String, String> args;
  private Map<String, String> headers;
  private String origin;
  private String url;

  @Override
  public String toString() {
    return "DemoDocument{" +
        "args=" + args +
        ", headers=" + headers +
        ", origin='" + origin + '\'' +
        ", url='" + url + '\'' +
        '}';
  }

  public Map<String, String> getArgs() {
    return args;
  }

  public void setArgs(Map<String, String> args) {
    this.args = args;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
