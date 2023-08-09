package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlagsTest {
  Flags f1;
  Flags f2;
  Flags f3;
  Flags f4;
  /**
   * Set up the Flags object.
   */

  @BeforeEach
  public void setup() {
    f1 = new Flags(Flags.FlagType.File_Names);
    f2 = new Flags(Flags.FlagType.Creation_Time);
    f3 = new Flags(Flags.FlagType.Last_Modified_Time);
    f4 = new Flags(Flags.FlagType.Hard_To_Easy);
  }

  @Test
  void testCompare() throws IOException {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("File1 -Easy");
    strings.add("File2 -Hard");
    f2.fileNames(strings);
    f4.sortDifficulty(strings);
    ArrayList<String> strings2 = new ArrayList<>();
    Path p = Paths.get("testCases/test1.sr");
    Path p2 = Paths.get("testCases/test1.sr");
    Files.setLastModifiedTime(p, FileTime.fromMillis(2000));
    Files.setAttribute(p2, "creationTime", FileTime.fromMillis(3000));
    strings2.add(p.toString());
    f3.modifiedDate(strings2);
    f2.createdDate(strings2);
    assertEquals("File2 -Hard", strings.get(0));
    assertEquals("File1 -Easy", strings.get(1));
    //assertEquals("testCases\\test1.sr", strings2.get(0));
  }
}