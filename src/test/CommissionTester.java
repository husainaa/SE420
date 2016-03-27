package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.CommissionCalculator;
import application.SalesTransaction;


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
		CommissionCalculator c2 = new CommissionCalculator("John", 2);
		
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
	
	// Test suite to test calculateBonusCommission()
	@Test
	public void BonusCommissionCalculatorTester(){
		
		// Create instances for PROBARIONARY type employers
		CommissionCalculator p1 = new CommissionCalculator("Ahmad", 0);
		CommissionCalculator p2 = new CommissionCalculator("Daniel", 0);
		CommissionCalculator p3 = new CommissionCalculator("David", 0);
		
		// Create instances for EXPERIENCED type employers
		CommissionCalculator e1 = new CommissionCalculator("John", 1);
		CommissionCalculator e2 = new CommissionCalculator("Ahab", 1);
		CommissionCalculator e3 = new CommissionCalculator("Ishmael", 1);
		
		// Create wrong type of experience employer
		CommissionCalculator w = new CommissionCalculator("Miller", 3);
		
		// To check bonuses for PROBATIONARY type employers, three cases. 
		// Amount exceeded threshold
		p1.addSale(0, 30000);
		p1.addSale(0, 30000);
		assertEquals(60000, p1.getTotalSales(),0); // Assure total sales is correct
		assertEquals(50,p1.calculateBonusCommission(),0); // Assure bonus is correct
		
		// Amount equals threshold, no bonus :(, close though ;)
		p2.addSale(0, 50000); 
		assertEquals(50000, p2.getTotalSales(),0); // Assure total sales is correct
		assertEquals(0,p2.calculateBonusCommission(),0); // Assure bonus is correct
		
		// Amount less than threshold, no bonus :(
		p3.addSale(0, 40000); 
		assertEquals(40000, p3.getTotalSales(),0); // Assure total sales is correct
		assertEquals(0,p3.calculateBonusCommission(),0); // Assure bonus is correct
		
		// To check bonuses for EXPERIENCED type employers, three cases. 
		// Amount exceeded threshold
		e1.addSale(0, 60000);
		e1.addSale(0, 60000); 
		assertEquals(120000, e1.getTotalSales(),0); // Assure total sales is correct
		assertEquals(300,e1.calculateBonusCommission(),0); // Assure bonus is correct
		
		// Amount equals threshold, no bonus :(, close though ;)
		e2.addSale(0, 100000.00); 
		assertEquals(100000.00, e2.getTotalSales(),0); // Assure total sales is correct
		assertEquals(0,e2.calculateBonusCommission(),0); // Assure bonus is correct
		
		// Amount less than threshold, no bonus :(
		e3.addSale(0, 90000); 
		assertEquals(90000, e3.getTotalSales(),0); // Assure total sales is correct
		assertEquals(0,e3.calculateBonusCommission(),0); // Assure bonus is correct	
		
		// Check if method still works with wrong type of parameters
		w.addSale(0, 90000); 
		assertEquals(90000, w.getTotalSales(),0); // Assure total sales is correct
		assertEquals(0,w.calculateBonusCommission(),0); // Assure bonus is correct	
	}
}

	
