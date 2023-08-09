package cs3500.pa01;

import cs3500.pa01.controller.ControllerThree;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - either 3 args or none
   */
  public static void main(String[] args) throws IOException {
    ControllerThree c3 = new ControllerThree(new InputStreamReader(System.in), System.out);
    c3.decideProgram(args);
  }
}