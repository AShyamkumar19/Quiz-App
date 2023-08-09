package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringToArrayTest {
  StringToArray sta;

  /**
   * Set up the StringToArray object.
   */
  @BeforeEach
  public void setup() {
    sta = new StringToArray();
  }

  /**
   * Test the stringToArray method.
   */

  @Test
  void testToArray() {
    String s = "Line 1\nLine 2\nLine 3\n";
    sta.toArray(s);
    ArrayList<String> expected = new ArrayList<>();
    expected.add("Line 1");
    expected.add("Line 2");
    expected.add("Line 3");
    assertEquals(expected, sta.toArray(s));
  }
}