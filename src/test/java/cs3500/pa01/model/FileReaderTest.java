package cs3500.pa01.model;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {
  FileReader fr;

  /**
   * Set up the FileReader object.
   */
  @BeforeEach
  public void setup() {
    fr = new FileReader();
  }

  @Test
   void preVisitDirectory() throws IOException {
    Path path = Paths.get("testCases/");
    BasicFileAttributes bf = Files.readAttributes(path, BasicFileAttributes.class);
    assertEquals(CONTINUE, fr.preVisitDirectory(path, bf));
  }

  @Test
  void visitFile() throws IOException {
    Path path = Paths.get("testCases/");
    Path path2 = Paths.get("testCases/test1.sr");
    BasicFileAttributes bf = Files.readAttributes(path, BasicFileAttributes.class);
    Files.walkFileTree(path, fr);
    Files.walkFileTree(path2, fr);
    assertEquals(CONTINUE, fr.preVisitDirectory(path, bf));
    assertEquals(CONTINUE, fr.visitFile(path2, bf));
  }

  @Test
  void visitFileFailed() throws IOException {
    assertEquals(CONTINUE, fr.visitFileFailed(Paths.get("testCases/"), new IOException()));
  }

  @Test
  void postVisitDirectory() throws IOException {
    assertEquals(CONTINUE, fr.postVisitDirectory(Paths.get("test2/"), new IOException()));
  }

  @Test
  void getData() {
    ArrayList<String> data = new ArrayList<>();
    assertEquals(data, fr.getData());
  }
}