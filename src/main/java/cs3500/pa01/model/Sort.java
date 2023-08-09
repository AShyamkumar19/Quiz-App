package cs3500.pa01.model;

import java.util.ArrayList;

/**
 * Represents the sorting methods.
 */
public interface Sort {
  public ArrayList<String> fileNames(ArrayList<String> data);

  public ArrayList<String> createdDate(ArrayList<String> data);

  public ArrayList<String> modifiedDate(ArrayList<String> data);

  public ArrayList<String> sortDifficulty(ArrayList<String> data);
}
