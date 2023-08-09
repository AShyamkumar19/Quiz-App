package cs3500.pa01.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the editing of the file.
 */
public class EditFile {

  /**
   * @param files - all files are read and appended together
   * @return - returns a String with all the contents of the files merged
   */
  public String formatFile(ArrayList<String> files) {
    Scanner sc;
    StringBuilder sb = new StringBuilder();
    for (String file : files) {
      try {
        sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          if (line.contains(":::")) {
            if (line.contains("[[") && line.contains("]]")) {
              String question = checkBox(line);
              sb.append(question).append(" -Hard").append("\n");
            } else if (line.contains("-")) {
              String question = removeDashLine(line);
              sb.append(question).append(" -Hard").append("\n");
            } else if (line.startsWith("#")) {
              String question = removeHash(line);
              sb.append(question).append(" -Hard").append("\n");
            } else {
              sb.append(line).append("\n");
            }
          }
          sb.append("\n");
        }
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
    }
    return removeBlankLines(sb.toString());
  }

  /**
   * This method is for formatting the questions of sr
   *
   * @param file - the file that contains the questions
   * @return - returns the questions formatted
   */
  public String formQs(ArrayList<String> file) {
    Scanner sc;
    StringBuilder sb = new StringBuilder();
    for (String f : file) {
      try {
        sc = new Scanner(new File(f));
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          sb.append(line).append("\n");
        }
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
    }
    return sb.toString();
  }

  /**
   * This method is for getting the question in the box.
   *
   * @param line - the line that contains ::: and [[ ]]
   * @return - returns the question that is in the box
   */
  public String checkBox(String line) {
    int startIndex = line.indexOf("[[");
    int endIndex = line.indexOf("]]");
    return line.substring(startIndex + 2, endIndex);
  }

  /**
   * This method removes the blank lines.
   *
   * @param lines - the lines that are blank
   * @return - returns the lines without the blank lines
   */
  public String removeBlankLines(String lines) {
    return lines.replaceAll("(?m)^[ \t]*\r?\n", "");
  }

  public String removeDashLine(String line) {
    line = line.substring(1).trim();
    return line;
  }

  public String removeHash(String line) {
    line = line.replaceFirst("^[^a-zA-Z]+", "").trim();
    return line;
  }
}
