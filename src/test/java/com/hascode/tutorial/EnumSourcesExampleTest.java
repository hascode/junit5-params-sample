package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class EnumSourcesExampleTest {

  @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
  @EnumSource(TimeUnit.class)
  void testTimeUnitMinimumNanos(TimeUnit unit) {
    assertTrue(unit.toMillis(2000000L) > 1);
  }

  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
  void testTimeUnitJustSecondsAndMinutes(TimeUnit unit) {
    assertTrue(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
    assertFalse(EnumSet
        .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
            TimeUnit.MICROSECONDS).contains(unit));
  }

  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, mode = Mode.EXCLUDE, names = {"SECONDS", "MINUTES"})
  void testTimeUnitExcludingSecondsAndMinutes(TimeUnit unit) {
    assertFalse(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
    assertTrue(EnumSet
        .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
            TimeUnit.MICROSECONDS).contains(unit));
  }

  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, mode = Mode.MATCH_ALL, names = ".*SECONDS")
  void testTimeUnitIncludingAllTypesOfSecond(TimeUnit unit) {
    assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES).contains(unit));
    assertTrue(EnumSet
        .of(TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
            TimeUnit.MICROSECONDS).contains(unit));
  }

}
