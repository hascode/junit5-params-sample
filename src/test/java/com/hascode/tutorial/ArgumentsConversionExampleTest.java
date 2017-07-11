package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

public class ArgumentsConversionExampleTest {

  @ParameterizedTest
  @ValueSource(strings = "2017-07-11")
  void testImplicitArgumentConversion(LocalDate date) throws Exception {
    assertTrue(date.getYear() == 2017);
    assertTrue(date.getMonth().equals(Month.JULY));
    assertTrue(date.getDayOfMonth() == 11);
  }

  @ParameterizedTest
  @ValueSource(strings = "B4627B3B-ACC4-44F6-A2EB-FCC94DAB79A5")
  void testImplicitArgumentConversion(@ConvertWith(ToUUIDArgumentConverter.class) UUID uuid)
      throws Exception {
    assertNotNull(uuid);
    assertTrue(uuid.getLeastSignificantBits() == -6706989278516512347L);
  }

  static class ToUUIDArgumentConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
      assertEquals(UUID.class, targetType, "may only convert to UUID");
      return UUID.fromString(String.valueOf(source));
    }
  }

}
