package cs3500.pa01.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuizModeTest {
  QuizMode qm;
  QuizMode qm2;
  StringBuilder sb;
  StringBuilder sb2;

  /**
   * Set up the QuizMode object.
   */
  @BeforeEach
  public void setup() {
    sb = new StringBuilder();
    sb2 = new StringBuilder();
    StringReader rd = new StringReader("5\n3\n4");
    StringReader rd2 = new StringReader("1\n2\n4");
    qm = new QuizMode(rd, sb);
    qm2 = new QuizMode(rd2, sb2);
  }

  @Test
  void testQuizMode() throws IOException {
    ArrayList<String> questions = new ArrayList<>();
    questions.add("What is the capital of France?:::Paris -Hard");
    questions.add("What is the capital of Germany?:::Berlin -Easy");
    questions.add("What is the capital of Italy?:::Rome -Hard");
    qm.quizMode(questions, 2, "testCases/test1.sr");
    qm2.quizMode(questions, 2, "testCases/test1.sr");
    assertEquals("What is the capital of France?\n" + "Enter 1 to mark question easy, "
        + "2 to mark question hard, 3 to see answer, 4 to exit: \n"
        + "Please enter a valid input: \n" + "Answer: Paris \nEnter 1 to continue: "
        + "What is the capital of Germany?\n" + "Enter 1 to mark question easy, "
        + "2 to mark question hard, 3 to see answer, 4 to exit: \n", sb.toString());
    assertEquals("What is the capital of France?\n"
        + "Enter 1 to mark question easy, 2 to mark question hard, 3 to see answer, 4 to exit: \n"
            + "What is the capital of Germany?\nEnter 1 to mark question easy, "
        + "2 to mark question hard, 3 to see answer, 4 to exit: \n", sb2.toString());

  }
}