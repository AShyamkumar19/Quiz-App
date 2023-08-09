package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarkQuestionsTest {
  MarkQuestions mq;

  /**
   * Set up the MarkQuestions object.
   */

  @BeforeEach
  public void setup() {
    mq = new MarkQuestions();
  }

  /**
   * Test the markQuestions method.
   */
  @Test
  void testMarkQuestions() {
    String s1 = "String 1 -Hard";
    String s2 = "String 2 -Easy";
    mq.checkWord(s1, 2);
    mq.checkWord(s2, 1);
    mq.markHard(s1);
    mq.markEasy(s2);
    assertEquals("String 1 -Hard", mq.checkWord(s1, 2));
    assertEquals("String 2 -Easy", mq.checkWord(s2, 1));
    assertEquals("String 1 -Easy", mq.checkWord(s1, 1));
    assertEquals("String 2 -Hard", mq.checkWord(s2, 2));
  }

}