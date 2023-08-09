package cs3500.pa01.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is the main driver of this project.
 */
public class ControllerThree {

  private final Readable rd;
  private final Appendable ap;

  public ControllerThree(Readable rd, Appendable ap) {
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * Decides which program to run based on the number of args.
   *
   * @param args - either 3 args or none
   */

  public void decideProgram(String[] args) throws IOException {
    ControllerOne c1 = new ControllerOne();
    ControllerTwo c2 = new ControllerTwo(rd, ap);
    Scanner sc = new Scanner(rd);
    // if there are no args, then the user is in study mode
    if (args.length == 0) {
      ap.append("Welcome to the Study App!\n");
      ap.append("Enter the path to the file you want to study from: \n");
      String path = sc.nextLine();
      if (path.equals("")) {
        throw new IllegalArgumentException("Illegal Path");
      }
      ap.append("Enter how many questions you want to answer: \n");
      int numQuestions = sc.nextInt();
      if (numQuestions < 0) {
        throw new IllegalArgumentException("Illegal Number of Questions");
      }
      c2.studyModeSetup(path, numQuestions);
    } else { // if there are 3 args, then the user is in quiz mode
      c1.createSr(args[0], args[1], args[2]);
    }
  }
}
