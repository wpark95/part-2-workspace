package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {

  private HourlyEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new HourlyEmployee("John", new Date(0), 50.0, 40.0);
  }

  @Test
  public void shouldGetCorrectPay() {
    assertEquals((50.0 * 40.0), employee.pay(), 0.005);
  }

  @Test
  public void shouldGetCorrectPayTaxes() {
    assertEquals((TaxPayer.HOURLY_TAX_RATE * 2000.0), employee.payTaxes(), 0.005);
  }

  @Test
  public void testEquals() {
    HourlyEmployee duplicate = new HourlyEmployee("John", new Date(0), 50.0, 40.0);
    assertTrue(employee.equals(duplicate));
  }

  @Test
  public void testHashCode() {
    HourlyEmployee duplicate = new HourlyEmployee("John", new Date(0), 50.0, 40.0);
    assertEquals(employee.hashCode(), duplicate.hashCode());
  }
}