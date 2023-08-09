package cs3500.pa01.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class that implements the ISort interface to sort files.
 */
public class Flags implements Sort, Comparator<String> {

  /**
   * Declares different types of flags in enums
   */
  public enum FlagType {
    File_Names,
    Creation_Time,
    Last_Modified_Time,
    Hard_To_Easy
  }

  private FlagType flagType;

  /**
   * @param flagType - type of flag
   */
  public Flags(FlagType flagType) {
    this.flagType = flagType;
  }

  /**
   * @param o1 - first String or can represent file
   * @param o2 - second String or can represent file
   * @return - 0 if equal, 1 if o1 is greater, -1 if o2 is greater
   */
  @Override
  public int compare(String o1, String o2) {
    File file1 = new File(o1);
    File file2 = new File(o2);
    try {
      BasicFileAttributes attr1 =
          Files.readAttributes(Paths.get(o1), BasicFileAttributes.class);
      BasicFileAttributes attr2 =
          Files.readAttributes(Paths.get(o2), BasicFileAttributes.class);

      return switch (flagType) {
        case Creation_Time -> attr1.creationTime().compareTo(attr2.creationTime());
        case Last_Modified_Time -> Long.compare(file1.lastModified(), file2.lastModified());
        default -> throw new IllegalStateException("Invalid comparison type");
      };
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * @param data  - Alphabetizes the file names
   * @return data - Alphabetized file names
   */
  @Override
  public ArrayList<String> fileNames(ArrayList<String> data) {
    this.flagType = FlagType.File_Names;
    Collections.sort(data);
    return data;
  }

  /**
   * @param data - Sorts files based on creation of data
   * @return data - outputs sorted Array list based on creation date
   */
  @Override
  public ArrayList<String> createdDate(ArrayList<String> data) {
    this.flagType = FlagType.Creation_Time;
    data.sort(this);
    return data;
  }

  /**
   * @param data - Sorts files based on last modified date
   * @return data - outputs sorted Array list based on last modified date
   */
  @Override
  public ArrayList<String> modifiedDate(ArrayList<String> data) {
    this.flagType = FlagType.Last_Modified_Time;
    data.sort(this);
    return data;
  }

  /**
   * @param data - Sorts files based on difficulty
   * @return data - outputs sorted Array list based on difficulty
   */
  @Override
  public ArrayList<String> sortDifficulty(ArrayList<String> data) {
    this.flagType = FlagType.Hard_To_Easy;
    ArrayList<String> hardLines = new ArrayList<>();
    ArrayList<String> easyLines = new ArrayList<>();

    for (String line : data) {
      if (line.endsWith("-Hard")) {
        hardLines.add(line);
      } else if (line.endsWith("-Easy")) {
        easyLines.add(line);
      }
    }

    Collections.shuffle(hardLines);
    easyLines.sort(Comparator.comparingInt(data::indexOf));

    data.clear();
    data.addAll(hardLines);
    data.addAll(easyLines);
    return data;
  }
}



