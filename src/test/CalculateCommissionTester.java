package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.CommissionCalculator;



/**
 * @author lenovo
 * This method is for testing the class method calculateCommission of the class CommissionCalculator
 * using junit test cases.
 */
public class CalculateCommissionTester {
	CommissionCalculator cProbLow;
	CommissionCalculator cProbCom;
	CommissionCalculator cExpLow;
	CommissionCalculator cExpCom;
	
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
	
	/**
	 * This method creates an employee with a sales record, it then checks for proper
	 * return from the CommissionCalculator class method calculateCommission
	 */
	@Test
	public void testCommissionCalculator(){
		CommissionCalculator cProbLow = new CommissionCalculator("Ned",0);
		cProbLow.addSale(0, 100);
		assertEquals(cProbLow.calculateCommission(),0,1.0);
		
		CommissionCalculator cExpLow = new CommissionCalculator("Fank",1);
		cExpLow.addSale(0, 100);
		assertEquals(cExpLow.calculateCommission(),0,1.0);
		
		CommissionCalculator cExpCom = new CommissionCalculator("Homer",1);
		cExpCom.addSale(1, 5000);
		cExpCom.addSale(1, 5000);
		assertEquals(300,cExpCom.calculateCommission(),1.0);
		
		CommissionCalculator cProbCom = new CommissionCalculator("Mike",0);
		cProbCom.addSale(0, 2000);
		cProbCom.addSale(1,400);
		assertEquals(12, cProbCom.calculateCommission(),1.0);
		
	}
	
}
