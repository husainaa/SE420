package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import application.SalesTransaction;
import application.iCommissionCalculator;




/**
 * @author lenovo
 * This class is responsible for setting up and testing the target class SalesTransaction.java
 * using Junit testing
 */
public class SalesTransactionTester {
	
	iCommissionCalculator c;
	
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
	 * @throws Exception
	 * This method tests the main constructor SalesTransaction for good transaction type input
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConstructorGoodType() throws Exception{
		
		SalesTransaction s = new SalesTransaction(0, 1);
		assertEquals(s.getTransactionType(), c.BASIC_ITEM);
		
	}
	
	/**
	 * This method tests the main constructor SalesTransaction for bad transaction type input
	 */
	@SuppressWarnings("unused")
	@Test
	public void testConstructorBadType(){
		try {
			SalesTransaction s = new SalesTransaction(5, 1);
		} catch (Exception e) {
			String exceptionString = "Invalid transaction type.";
			//System.out.printf("%s", e.getMessage());
			assertEquals(e.getMessage(),exceptionString);
		}
	}
	
	/**
	 * @throws Exception
	 * This method tests the main constructor SalesTransaction for correct transaction range
	 * This method also tests the getTransactionAmount() method
	 */
	@SuppressWarnings("unused")
	@Test
	public void testGoodTransactionAmount() throws Exception{
		//test for valid transaction amount
		SalesTransaction s = new SalesTransaction(0, 1);
		assertEquals(s.getTransactionAmount(),1,0.01);
		//test for upper range of correct transaction value
		SalesTransaction s1 = new SalesTransaction(0, Integer.MAX_VALUE);
		assertEquals(s1.getTransactionAmount(),Integer.MAX_VALUE,0.01);
	}
	
	/**
	 * This method tests the main constructor SalesTransaction for incorrect transaction range
	 */
	@SuppressWarnings("unused")
	@Test
	public void testBadTransactionAmount(){
		//test for zero transaction amount
		try {
			SalesTransaction s = new SalesTransaction(0, 0);
		} catch (Exception e) {
			String exceptionString = "Invalid transaction amount.";
			//System.out.printf("%s", e.getMessage());
			assertEquals(e.getMessage(),exceptionString);
		}
		//test for minimum integer value amount
		try {
			SalesTransaction s = new SalesTransaction(0, Integer.MIN_VALUE);
		} catch (Exception e) {
			String exceptionString = "Invalid transaction amount.";
			//System.out.printf("%s", e.getMessage());
			assertEquals(e.getMessage(),exceptionString);
		}
	}
	
}
