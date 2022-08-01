/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertEquals(7, tvs.size());
    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  @Test
  public void testFindByBrandsNoMatches() {
    Map<String,Collection<Television>> tvs = Catalog.findByBrands();
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandsWithMatches() {
    Map<String,Collection<Television>> tvs = Catalog.findByBrands("Sony", "Zenith", "NO-MATCHES");
    assertNotNull(tvs);
    assertEquals(2, tvs.keySet().size());
    assertEquals(7, tvs.get("Sony").size());
    assertEquals(9, tvs.get("Zenith").size());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testGetInventory_invalid() {
    Collection<Television> tvs = Catalog.getInventory();
    Television television = new Television();
    tvs.add(television);
    tvs.remove(television);
    tvs.clear();
  }

  @Test
  public void removeDuplicates() {
    Set<Television> tvs = new HashSet<>(Catalog.getInventory());
    assertEquals(23, tvs.size());
  }

  @Test
  public void findLoudest() {
    Collection<Television> tvs = Catalog.getInventory();
    Television loudest = new Television("Sony", 0);
    for (Television tv : tvs) {
      if (tv.getVolume() > loudest.getVolume()) {
        loudest = tv;
      }
    }
    System.out.println(loudest.toString() + " is the loudest TV.");
  }

}