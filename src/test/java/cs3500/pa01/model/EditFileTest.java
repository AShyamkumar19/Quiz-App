package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditFileTest {
  EditFile ef;

  /**
   * Set up the EditFile object.
   */

  @BeforeEach
  public void setup() {
    ef = new EditFile();
  }

  /**
   * Test the changeFileContents method.
   */

  @Test
  void testFormateFile() {
    ArrayList<String> x = new ArrayList<>();
    x.add("OutputsTestFiles/newFile.sr");
    ef.formatFile(x);
  }

  @Test
  void testCheckBox() {
    String x = "[[What is the capital of Spain?:::Madrid]]";
    ef.checkBox(x);
    assertEquals("What is the capital of Spain?:::Madrid", ef.checkBox(x));
  }

  @Test
  void testFormQ() {
    ArrayList<String> f = new ArrayList<>();
    f.add("testCases/test.sr");
    //ef.formQs(f);
    //assertEquals(",", ef.formQs(f));
  }

  @Test
  void testRemoveHash() {
    String x = "#Word";
    assertEquals("Word", ef.removeHash(x));
  }

}