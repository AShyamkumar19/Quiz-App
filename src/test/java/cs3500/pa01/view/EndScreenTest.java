package cs3500.pa01.view;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndScreenTest {
  EndScreen es;

  /**
   * Set up the EndScreen object.
   */

  @BeforeEach
  public void setup() {
    es = new EndScreen();
  }

  /**
   * Test the endScreen method.
   */

  @Test
  void testEndScreen() {
    ArrayList<String> questions = new ArrayList<>();
    questions.add("Question 1 -Easy");
    questions.add("Question 2 -Hard");
    questions.add("Question 3 -Easy");
    questions.add("Question 4 -Hard");
    ArrayList<String> q2 = new ArrayList<>();
    q2.add("Question 1 -Hard");
    q2.add("Question 2 -Easy");
    q2.add("Question 3 -Hard");
    q2.add("Question 4 -Easy");
    es.endScreen(questions, 4, q2);
  }
}