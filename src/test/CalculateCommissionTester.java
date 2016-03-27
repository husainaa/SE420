package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.CommissionCalculator;



public class CalculateCommissionTester {
	CommissionCalculator cProbLow;
	CommissionCalculator cProbCom;
	CommissionCalculator cProbBon;
	CommissionCalculator cExpLow;
	CommissionCalculator cExpCom;
	CommissionCalculator cExpBon;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//create employees to calculate commissions. This is using equivalence partitioning
		
		/*
		CommissionCalculator cProbCom = new CommissionCalculator("Mike",0);
		cProbCom.addSale(1, 2001);
		
		CommissionCalculator cProbBon = new CommissionCalculator("Roy",0);
		cProbBon.addSale(2, 50001);
	
		CommissionCalculator cExpBon = new CommissionCalculator("Bart",1);
		cExpBon.addSale(3, 100001);
		*/

	}

	@After
	public void tearDown() throws Exception {
	}
	
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
