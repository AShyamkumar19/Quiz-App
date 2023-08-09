package cs3500.pa01.view;

import java.util.ArrayList;

/**
 * Represents the updated questions.
 */
public class UpdatedQuestions {
  /**
   * Displays the total number of questions of a certain difficulty in the new arrayList
   *
   * @param newQs      the updated questions
   * @param difficulty easy/hard
   */
  public void totalQuestions(ArrayList<String> newQs, String difficulty) {
    int total = 0;
    for (String newQ : newQs) {
      if (newQ.contains(difficulty)) {
        total++;
      }
    }
    System.out.println("Total number of " + difficulty.toLowerCase() + " questions: " + total);
  }
}
