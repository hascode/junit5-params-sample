package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ArgumentsSourceExampleTest {

  @ParameterizedTest
  @ArgumentsSource(CustomArgumentsGenerator.class)
  void testGeneratedArguments(double number) throws Exception {
    assertFalse(number == 0.D);
    assertTrue(number > 0);
    assertTrue(number < 1);
  }

  static class CustomArgumentsGenerator implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
          .map(Arguments::of);
    }
  }
}
