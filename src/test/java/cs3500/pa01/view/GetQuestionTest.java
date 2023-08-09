package cs3500.pa01.view;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetQuestionTest {
  GetQuestion gq;

  /**
   * Set up the GetQuestion object.
   */

  @BeforeEach
  public void setup() {
    gq = new GetQuestion();
  }

  /**
   * Test the getQuestion method.
   */

  @Test
  void testDisplayQuestion() {
    ArrayList<String> questions = new ArrayList<>();
    questions.add("Question::: 1 -Easy");
    questions.add("Question::: 2 -Hard");
    questions.add("Question::: 3 -Easy");
    questions.add("Question::: 4 -Hard");
    gq.displayQuestion(questions, 2);
  }

  /**
   * Test the getAnswer method.
   */

  @Test
  void testDisplayAnswer() {
    ArrayList<String> questions = new ArrayList<>();
    questions.add("Question::: 1 -Easy");
    questions.add("Question ::: 2 -Hard");
    questions.add("Question::: 3 -Easy");
    questions.add("Question::: 4 -Hard");
    gq.displayAnswer(questions, 2);
  }
}