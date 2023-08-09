package cs3500.pa01.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTwoTest {
  ControllerTwo c2;
  StringBuilder sb;

  /**
   * Set up the ControllerTwo object.
   */
  @BeforeEach
  public void setup() {
    sb = new StringBuilder();
    StringReader sr = new StringReader("2");
    c2 = new ControllerTwo(sr, sb);

  }

  /**
   * Test the studyModeSetup method.
   */
  @Test
  void testStudyModeSetup() throws IOException {
    //c2.studyModeSetup("testCases/test2.sr", 4);
  }
}