package cs3500.pa01.controller;

import cs3500.pa01.model.MarkQuestions;
import cs3500.pa01.model.WriteToFile;
import cs3500.pa01.view.EndScreen;
import cs3500.pa01.view.GetQuestion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class represents the quiz mode of the flashcard application.
 * Displays all the questions and allows the user to interact with program
 */

public class QuizMode {

  final Readable rd;
  final Appendable ap;

  public QuizMode(Readable rd, Appendable ap) {
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * @param questions - the arraylist of questions
   * @param numOfQs - the number of questions to be asked
   * @param path - the path to the file
   */
  public void quizMode(ArrayList<String> questions, int numOfQs, String path) throws IOException {
    GetQuestion gq = new GetQuestion();
    MarkQuestions mq = new MarkQuestions();
    EndScreen es = new EndScreen();
    Scanner sc = new Scanner(rd);
    WriteToFile wf = new WriteToFile();

    //index keeps track of the current question being displayed
    int index = 0;
    boolean exit = false;
    // updatedQs keeps track of the questions that have been marked easy or hard
    ArrayList<String> updatedQs = new ArrayList<>();
    // runs all the questions in the arraylist
    System.out.print("Starting quiz, click 1 to start: ");
    while (sc.hasNextInt() && (index < numOfQs && !exit)) {
      ap.append(gq.displayQuestion(questions, index)).append("\n");
      ap.append("Enter 1 to mark question easy, 2 to mark question hard, 3 to see answer, "
          + "4 to exit: ");
        int userInput = sc.nextInt();
        ap.append("\n");
        // checks if the user input is valid
        while (userInput < 1 || userInput > 4) {
          ap.append("Please enter a valid input: ");
          ap.append("\n");
          userInput = sc.nextInt();
        }
        // handles the user input
        if (userInput == 1) {
          updatedQs.add(mq.checkWord(questions.get(index), userInput));
          index++;
        } else if (userInput == 2) {
          updatedQs.add(mq.checkWord(questions.get(index), userInput));
          index++;
        } else if (userInput == 3) {
          ap.append("Answer: ").append(gq.displayAnswer(questions, index)).append("\n");
          updatedQs.add(questions.get(index));
          index++;
          ap.append("Enter 1 to continue: ");
        } else {
          exit = true;
        }
    }
    es.endScreen(questions, index, updatedQs);
    wf.changeFileContents(path, questions, updatedQs);
  }
}
