package com.javatunes.personnel;

import org.junit.runner.JUnitCore;

public class AllTests {

  public static void main(String[] args) {
    JUnitCore.runClasses(HourlyEmployeeTest.class, SalariedEmployeeTest.class);
  }

}
