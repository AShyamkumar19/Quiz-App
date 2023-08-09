package cs3500.pa01.view;

import java.util.ArrayList;

/**
 * Represents the updated questions.
 */
public class GetQuestion {

  /**
   * Displays the question.
   *
   * @param qs    the whole question
   * @param index the index of the question
   * @return the question
   */
  public String displayQuestion(ArrayList<String> qs, int index) {
    String line = qs.get(index);
    line = line.replaceAll("\\s*:::\\s*", ":::");
    int symbolIndex = line.indexOf(":::");
    String question = line.substring(0, symbolIndex);
    return question;
  }

  /**
   * Displays the answer.
   *
   * @param qs    the whole question
   * @param index the index of the question
   * @return the answer
   */
  public String displayAnswer(ArrayList<String> qs, int index) {
    String line = qs.get(index);
    int symbolIndex = line.indexOf(":::");
    String answer = line.substring(symbolIndex + 3);
    if (answer.contains("-Hard")) {
      int suffixIndex = answer.indexOf("-Hard");
      answer = answer.substring(0, suffixIndex);
      return answer;
    } else {
      int suffixIndex = answer.indexOf("-Easy");
      answer = answer.substring(0, suffixIndex);
      return answer;
    }
  }
}
