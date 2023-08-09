package cs3500.pa01.controller;

import cs3500.pa01.model.EditFile;
import cs3500.pa01.model.Flags;
import cs3500.pa01.model.StringToArray;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is the controller for the study mode.
 * Only occurs if they're no args
 */
public class ControllerTwo {

  final Readable rd;
  final Appendable ap;

  public ControllerTwo(Readable rd, Appendable ap) {
    this.rd = Objects.requireNonNull(rd);
    this.ap = Objects.requireNonNull(ap);
  }

  /**
   * This method is the controller for the study mode.
   *
   * @param path the path to the file
   * @param numQuestions the number of questions to be asked
   */
  public void studyModeSetup(String path, int numQuestions) throws IOException {
    EditFile ef = new EditFile();
    StringToArray sa = new StringToArray();
    Flags f = new Flags(Flags.FlagType.Hard_To_Easy);
    QuizMode qm = new QuizMode(rd, ap);


    Path p = Paths.get(path);
    ArrayList<String> file = new ArrayList<>();
    file.add(p.toString());
    ArrayList<String> formattedData = sa.toArray(ef.formQs(file));
    formattedData = f.sortDifficulty(formattedData);

    int totalQs = Math.min(numQuestions, formattedData.size());
    qm.quizMode(formattedData, totalQs, path);
  }
}
