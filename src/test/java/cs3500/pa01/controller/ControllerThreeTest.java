package cs3500.pa01.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerThreeTest {
  ControllerThree c3;
  ControllerThree c3b;
  StringBuilder sb;
  StringBuilder sb2;

  /**
   * Set up the ControllerThree object.
   */
  @BeforeEach
  public void setup() {
    sb = new StringBuilder();
    sb2 = new StringBuilder();
    StringReader sr = new StringReader("testCases/test2.sr\n2\n2\n3\n4\n");
    StringReader sr2 = new StringReader("");
    c3b = new ControllerThree(sr2, sb2);
    c3 = new ControllerThree(sr, sb);
  }

  /**
   * Test the decideProgram method.
   */
  @Test
  void testDecideProgram() throws IOException {
    String[] args = {"testCases/", "createdDate", "testCases/testing/output.sr"};
    c3b.decideProgram(args);
    String[] args2 = {};
    c3.decideProgram(args2);
    assertEquals("Welcome to the Study App!\n"
        + "Enter the path to the file you want to study from: \n"
        + "Enter how many questions you want to answer: \n", sb.toString());
  }

}