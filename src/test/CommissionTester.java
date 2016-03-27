package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.CommissionCalculator;


public class CommissionTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	// Test Suite to test setters and getters
	@Test
	public void SettersAndGetters() {
		
		// Create an instance of Commission Calculator 
		CommissionCalculator c = new CommissionCalculator("Ahmad", 0);
		CommissionCalculator c2 = new CommissionCalculator("Ahmad", 2);
		
		// Test getName()
		assertEquals("Ahmad", c.getName());
		
		// Test getMinimumSales() and getMinimumSalesForBonus() for PROBATIONARY employer
		assertEquals(2000, c.getMinimumSales(),0);
		assertEquals(50000, c.getMinimumSalesForBonus(),0);
		
		// Test getMinimumSales() and getMinimumSalesForBonus() for EXPERIENCED employer
		c.setEmployeeExperience(1); // To set it to an EXPERIENCED employer
		assertEquals(5000, c.getMinimumSales(),0);
		assertEquals(100000, c.getMinimumSalesForBonus(),0);
		
		// Test getMinimumSales() and getMinimumSalesForBonus() for wrong experience parameter
		assertEquals(0,c2.getMinimumSales(),0);
		assertEquals(0, c2.getMinimumSalesForBonus(),0);
		
		// Test setEmployeeExperience()
		assertEquals(1, c.getExperience());
		c.setEmployeeExperience(0); // Set it back to PROBATIONARY employer
		assertEquals(0, c.getExperience());
		
		// Test addSale() and getTotalSales()
		c.addSale(0, 100);
		c.addSale(0, 100);
		assertEquals(200,c.getTotalSales(),0);
	}
	
}
