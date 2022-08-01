package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee employee;
  private SalariedEmployee employee2;

  @Before
  public void setUp() throws Exception {
    employee = new SalariedEmployee("John", new Date(0), 1000.0);
    employee2 = new SalariedEmployee("John", new Date(0), 1000.0);
  }

  @Test
  public void pay() {
    assertEquals(1000.0, employee.pay(), 0.005);
  }

  @Test
  public void payTaxes() {
    assertEquals((1000 * TaxPayer.SALARIED_TAX_RATE), employee.payTaxes(), 0.005);
  }

  @Test
  public void equals_same() {
    //noinspection SimplifiableAssertion
    assertTrue(employee.equals(employee2));
  }

  @Test
  public void equals_different() {
    employee2.setName("Ron");
    //noinspection SimplifiableAssertion
    assertFalse(employee.equals(employee2));
  }

  @Test
  public void hashCode_same() {
    assertEquals(employee2.hashCode(), employee.hashCode());
  }

  @Test
  public void hashCode_different() {
    employee2.setName("Ronda");
    assertNotEquals(employee2.hashCode(), employee.hashCode());
  }

}