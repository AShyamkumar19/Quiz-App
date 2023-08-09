package cs3500.pa01.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerOneTest {
  ControllerOne c1;

  /**
   * Set up the ControllerOne object.
   */
  @BeforeEach
  public void setup() {
    c1 = new ControllerOne();
  }

  /**
   * Test the createSr method.
   */
  @Test
  void testCreateSr() {
    c1.createSr("testCases/", "filenames", "OutputsTestFiles/newFile.sr");
    c1.createSr("testCases/", "createdDate", "OutputsTestFiles/newFile.sr");
    c1.createSr("testCases/", "modifiedDate", "OutputsTestFiles/newFile.sr");
  }
}