package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SomeParameterizedTest {

  @Test
  void shouldDivideByTwo() throws Exception {
    int[] numbers = {2, 4, 6, 12, 24};
    assertAll("numbers are even",
        () -> assertEquals(numbers[0] % 2, 0),
        () -> assertEquals(numbers[1] % 2, 0),
        () -> assertEquals(numbers[2] % 2, 123),
        () -> assertEquals(numbers[3] % 2, 0),
        () -> assertEquals(numbers[4] % 2, 0)
    );
  }

  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  void testWithValueSource(int argument) {
    assertNotNull(argument);
  }
}
