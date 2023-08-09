package cs3500.pa01.view;

import java.util.ArrayList;

/**
 * Represents the end screen of the study session.
 */
public class EndScreen {
  /**
   * Displays all the stats of the study session.
   *
   * @param qs       the original questions
   * @param numOfQs  the number of questions answered
   * @param newQs    the updated questions
   */
  public void endScreen(ArrayList<String> qs, int numOfQs, ArrayList<String> newQs) {
    GetStats gs = new GetStats();
    final UpdatedQuestions uq = new UpdatedQuestions();

    System.out.println("End of Study Session\n Here are your stats:");
    System.out.println("Number of questions answered: " + numOfQs);
    gs.easyToHard(qs, newQs, numOfQs);
    gs.hardToEasy(qs, newQs, numOfQs);
    uq.totalQuestions(newQs, "Hard");
    uq.totalQuestions(newQs, "Easy");

  }
}
