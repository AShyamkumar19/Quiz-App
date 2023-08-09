package cs3500.pa01.controller;

import cs3500.pa01.model.EditFile;
import cs3500.pa01.model.FileReader;
import cs3500.pa01.model.Flags;
import cs3500.pa01.model.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class is the controller that creates a sr file
 * Only occurs if they're 3 args
 */
public class ControllerOne {
  /**
   * This method is for creating a sr file.
   *
   * @param path the path to the file
   * @param flag the flag to sort by
   * @param output the output file
   */
  public void createSr(String path, String flag, String output) {
    FileReader fr = new FileReader();
    Flags f1 = new Flags(Flags.FlagType.File_Names);
    Flags f2 = new Flags(Flags.FlagType.Creation_Time);
    Flags f3 = new Flags(Flags.FlagType.Last_Modified_Time);
    EditFile ef = new EditFile();
    WriteToFile wf = new WriteToFile();

    try {
      // gets file/files from path
      Files.walkFileTree(Paths.get(path), fr);
      ArrayList<String> sortedData = switch (flag) {
        case "filenames" -> f1.fileNames(fr.getData());
        case "createdDate" -> f2.createdDate(fr.getData());
        case "modifiedDate" -> f3.modifiedDate(fr.getData());
        default -> throw new IllegalArgumentException();
      };
      // sorts data based on flag

      // formats data and writes to file
      String formattedData = ef.formatFile(sortedData);
      wf.writeToFile(output, formattedData);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
