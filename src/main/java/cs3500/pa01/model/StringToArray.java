package cs3500.pa01.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * class that stores each string into an Array
 */
public class StringToArray {
  /**
   * @param lines - each will be stored in an ArrayList
   * @return the lines in an array
   */
  public ArrayList<String> toArray(String lines) {
    String[] lineArray = lines.split("\\r?\\n");
    return new ArrayList<>(Arrays.asList(lineArray));
  }
}
