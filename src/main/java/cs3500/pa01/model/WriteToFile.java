package cs3500.pa01.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that writes to a file.
 */
public class WriteToFile {

  /**
   * @param path - the path to where to write the file
   * @param contents - the contents to write to the file
   */
  public void writeToFile(String path, String contents) {
    try {
      FileWriter fw = new FileWriter(path);
      fw.write(contents);
      fw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   *
   * @param path - the path to where to write the file
   * @param baseContents - the original contents of the file
   * @param newContents - the new contents of the file
   */
  public void changeFileContents(String path, ArrayList<String> baseContents,
                                 ArrayList<String> newContents) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < baseContents.size(); i++) {
      String oldLine = baseContents.get(i);
      String updatedLine;
      if (i < newContents.size()) {
        updatedLine = newContents.get(i);
        if (!oldLine.endsWith(updatedLine.substring(updatedLine.length() - 5))) {
          sb.append(updatedLine).append("\n");
        } else {
          sb.append(oldLine).append("\n");
        }
      } else {
        sb.append(oldLine).append("\n");
      }
    }

    try {
      FileWriter fw = new FileWriter(path);
      fw.write(sb.toString());
      fw.close();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
