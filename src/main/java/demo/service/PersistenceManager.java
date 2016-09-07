package demo.service;

import java.io.File;

public class PersistenceManager {
  public boolean createDirectoryStructure(String path) {
    File f = new File(path);
    if (!f.exists()) {
      return f.mkdirs();
    }
    return false;
  }
}
