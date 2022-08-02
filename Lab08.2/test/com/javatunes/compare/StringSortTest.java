/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class StringSortTest {

  static final int TIMEOUT = 1000;

  private List<String> names  = Arrays.asList("Jason", "Martin", "Jack", "Mary", "Jill", "Frederick", "Laurie", "Ed");
  private List<String> sports = Arrays.asList("football", "baseball", "tennis", "soccer", "squash", "rugby", "racquetball", "golf", "cricket", "basketball");
  
  @Test(timeout = TIMEOUT + 100)
  public void testSortLambda() {
    System.out.println("testSortLambda:");
    
    System.out.println("Names sort - increasing length - lambda:");
    names.sort(Comparator.comparing((s) -> s.length()));
    System.out.println(names + "\n");
    
    System.out.println("Sports sort - increasing length - lambda:");
    sports.sort(Comparator.comparing(String::length));
    System.out.println(sports);
  }
  
  @Test
  public void testSortLambdaMethodCall() {
    System.out.println("testSortLambdaMethodCall:");
    
    // TODO: sort names by calling private helper method from the lambda body
    System.out.println("Names sort - increasing length - lambda that calls another method:");
     names.sort((s1, s2) -> compareStrings(s1, s2));
     System.out.println(names + "\n");
    
    // TODO: sort sports by calling private helper method from the lambda body
    System.out.println("Sports sort - increasing length - lambda that calls another method:");
     sports.sort((s1, s2) -> compareStrings(s1, s2));
     System.out.println(sports);
  }
    
  @Test
  public void testSortMethodReference() {
    System.out.println("testSortMethodReference:");
    
    // TODO: sort names by using a method reference
    System.out.println("Names sort - increasing length - method reference:");
     names.sort(StringSortTest::compareStrings);
     System.out.println(names + "\n");
    
    // TODO: sort sports by using a method reference
    System.out.println("Sports sort - increasing length - method reference:");
     sports.sort(StringSortTest::compareStrings);
     System.out.println(sports);
  }
  
  private static int compareStrings(String s1, String s2) {
    return s1.length() - s2.length();
  }
}