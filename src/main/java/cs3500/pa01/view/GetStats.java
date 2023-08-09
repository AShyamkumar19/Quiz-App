package cs3500.pa01.view;

import java.util.ArrayList;

/**
 * This class is used to get the statistics of the questions that have been changed from easy to
 * hard and vice versa.
 */
public class GetStats {
  private boolean printEasyToHardStats = false;
  private boolean printHardToEasyStats = false;

  /**
   * This method is used to get the statistics of the questions that have been changed from easy to
   * hard
   *
   * @param qs    the original questions
   * @param newQs the updated questions
   * @param index the index of the question
   */
  public void easyToHard(ArrayList<String> qs, ArrayList<String> newQs, int index) {
    printEasyToHardStats = true;
    changedDifficulty(qs, newQs, index, "-Easy", "-Hard");
    printEasyToHardStats = false;
  }

  /**
   * This method is used to get the statistics of the questions that have been changed from hard to
   * easy
   *
   * @param qs    the original questions
   * @param newQs the updated questions
   * @param index the index of the question
   */
  public void hardToEasy(ArrayList<String> qs, ArrayList<String> newQs, int index) {
    printHardToEasyStats = true;
    changedDifficulty(qs, newQs, index, "-Hard", "-Easy");
    printHardToEasyStats = false;
  }

  /**
   * This method compares the original questions to the updated questions and prints out the number
   * of questions that have been changed from easy to hard or hard to easy.
   *
   * @param qs    the original questions
   * @param newQs the updated questions
   * @param index the index of the question
   * @param s     the string that represents easy or hard
   * @param s2    the string that's compared to s (also easy or hard)
   */
  public void changedDifficulty(ArrayList<String> qs, ArrayList<String> newQs, int index,
                                String s, String s2) {
    int count = 0;
    for (int i = 0; i < index; i++) {
      String qsLine = qs.get(i);
      String newQsLine = newQs.get(i);
      if ((qsLine.contains(s) && newQsLine.contains(s2))) {
        count++;
      }
    }

    if (printEasyToHardStats) {
      System.out.println("Number of questions changed from easy to hard: " + count);
    }

    if (printHardToEasyStats) {
      System.out.println("Number of questions changed from hard to easy: " + count);
    }
  }
}
