package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private static final int INITIAL_VOLUME = 50;

  private Television television;
  private Television television2;


  @Before
  public void setUp() throws Exception {
    television = new Television("Sony", INITIAL_VOLUME, DisplayType.OLED);
    television2 = new Television("LG", INITIAL_VOLUME, DisplayType.OLED);
  }

  @Test
  public void shouldGetCorrectBrand() {
    assertEquals("Sony", television.getBrand());
  }

  @Test
  public void shouldSetCorrectBrand() {
    television.setBrand("Samsung");
    assertEquals("Samsung", television.getBrand());
  }

  @Test
  public void shouldGetCorrectVolume() {
    assertEquals(INITIAL_VOLUME, television.getVolume());
  }

  @Test
  public void setVolume_valid() {
    television.setVolume(Television.MIN_VOLUME + 1);
    assertEquals(Television.MIN_VOLUME + 1, television.getVolume());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_invalid() {
    television.setVolume(Television.MIN_VOLUME - 1);
  }

  @Test
  public void shouldGetCorrectCurrentChannel() {
    assertEquals(3, television.getCurrentChannel());
  }

  @Test
  public void changeChannel_valid() throws InvalidChannelException {
    television.changeChannel(4);
    assertEquals(4, television.getCurrentChannel());
  }

  @Test(expected = InvalidChannelException.class)
  public void changeChannel_invalid() throws InvalidChannelException {
    television.changeChannel(Television.MAX_CHANNEL + 1);
  }

  @Test
  public void getDisplay() {
    assertEquals(DisplayType.OLED, television.getDisplay());
  }

  @Test
  public void setDisplay() {
    television.setDisplay(DisplayType.LED);
    assertEquals(DisplayType.LED, television.getDisplay());
  }

  @Test
  public void shouldCompareToCorrectBrand() {
    assertEquals(7, television.compareTo(television2));
  }

  @Test
  public void shouldCompareToCorrectBrandWhenDuplicateBrand() throws InvalidChannelException {
    assertEquals(7, television.compareTo(television2));
  }

  @Test
  public void testHashCode() {
    television2.setBrand("Sony");
    assertEquals(television.hashCode(), television2.hashCode());
  }

  @Test
  public void testEquals() {
    television2.setBrand("Sony");
    assertTrue(television.equals(television2));
  }

}