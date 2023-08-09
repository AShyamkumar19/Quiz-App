package cs3500.pa01.model;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WriteToFileTest {
  WriteToFile wf;

  /**
   * Set up the WriteToFile object.
   */
  @BeforeEach
  public void setup() {
    wf = new WriteToFile();
  }

  /**
   * Test the changeFileContents method.
   */

  @Test
  void testChangeFileContents() {
    ArrayList<String> bq = new ArrayList<>();
    bq.add("What is the capital of France? -Hard");
    bq.add("What is the capital of Germany? -Hard");
    bq.add("What is the capital of Italy? -Easy");
    bq.add("What is the capital of Spain? -Easy");
    ArrayList<String> nq = new ArrayList<>();
    nq.add("What is the capital of France? -Easy");
    nq.add("What is the capital of Germany? -Easy");
    nq.add("What is the capital of Italy? -Hard");
    nq.add("What is the capital of Spain? -Hard");
    wf.changeFileContents("testCases/test1.sr", bq, nq);
  }
}