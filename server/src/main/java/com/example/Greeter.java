package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
   * Desciption.
   * @param someone   Someone parameter.
   * @return          Returns a message.
   */
  public final String greet(final String someone) {
    return String.format("Welcome %s!", someone);
  }
}
