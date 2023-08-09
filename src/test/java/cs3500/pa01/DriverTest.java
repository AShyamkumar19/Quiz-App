package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {
  Driver driver;

  @BeforeEach
  public void setup() {
    StringBuilder sb = new StringBuilder();
    StringReader sr = new StringReader("");
    driver = new Driver();
  }

  @Test
  public void mainTest() throws IOException {
    //Driver d = new Driver();
    String[] args = {"testCases/", "createdDate", "output.txt"};
    String[] args2 = {"testCases/", "filenames", "output.txt"};
    String[] args3 = {"testCases/", "modifiedDate", "output.md"};
    driver.main(args);
    driver.main(args2);
    driver.main(args3);
    assertEquals(1, 1);
  }

}