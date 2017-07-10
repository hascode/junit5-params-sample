package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourcesExampleTest {

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 8})
  void testNumberShouldBeEven(int num) {
    assertEquals(0, num % 2);
  }

  @ParameterizedTest
  @ValueSource(strings = {"Radar", "Rotor", "Tenet", "Madam", "Racecar"})
  void testStringShouldBePalindrome(String word) {
    assertEquals(isPalindrome(word), true);
  }

  @ParameterizedTest
  @ValueSource(doubles = {2.D, 4.D, 8.D})
  void testDoubleNumberBeEven(double num) {
    assertEquals(0, num % 2);
  }

  boolean isPalindrome(String word) {
    return word.toLowerCase().equals(new StringBuffer(word.toLowerCase()).reverse().toString());
  }
}
