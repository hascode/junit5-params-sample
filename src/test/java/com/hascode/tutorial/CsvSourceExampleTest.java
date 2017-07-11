package com.hascode.tutorial;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceExampleTest {

  Map<Long, String> idToUsername = new HashMap<>();

  {
    idToUsername.put(1L, "Selma");
    idToUsername.put(2L, "Lisa");
    idToUsername.put(3L, "Tim");
  }

  @ParameterizedTest
  @CsvSource({"1,Selma", "2,Lisa", "3,Tim"})
  void testUsersFromCsv(long id, String name) {
    assertTrue(idToUsername.containsKey(id));
    assertTrue(idToUsername.get(id).equals(name));
  }
}
