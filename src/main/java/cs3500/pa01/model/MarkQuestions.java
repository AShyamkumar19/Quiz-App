package cs3500.pa01.model;

/**
 * This class marks the questions as easy or hard.
 */
public class MarkQuestions {

  /**
   * This method checks if the user input is 1 or 2 and marks the question as easy or hard
   *
   * @param line - the question
   * @param input - the user input
   * @return line - the question
   */
  public String checkWord(String line, int input) {
    if (line.contains("-Hard") && input == 1) {
      return markEasy(line);
    } else if (line.contains("-Easy") && input == 2) {
      return markHard(line);
    }
    return line;
  }

  /**
   * @param line - the question
   * @return line - the question
   */
  public String markHard(String line) {
    int index = line.indexOf("-Easy");
    if (index != -1) {
      line = line.substring(0, index) + "-Hard";
    }
    return line;
  }

  /**
   * This method marks the question as easy
   *
   * @param line - the question
   * @return line - the question
   */
  public String markEasy(String line) {
    int index = line.indexOf("-Hard");
    if (index != -1) {
      line = line.substring(0, index) + "-Easy";
    }
    return line;
  }
}
