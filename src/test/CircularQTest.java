package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.CircularQueue;
import application.FixedSizeQueueInterface;

/**
 * @author Ahmad and Michael
 *
 * @param <E>
 */

public class CircularQTest<E> {

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
	
	private CircularQueue myq;
	
	/**
	 * test0() will test the isEmpty() and getQueueCapacity() methods.
	 * @throws Exception
	 */
	@Test 
	public void test0() throws Exception {

		myq = new CircularQueue<E>(0);
		assertEquals(true, myq.isEmpty());
		assertEquals(1, myq.getQueueCapacity());
		
		myq.offer(6);
		myq.offer(7);
		assertEquals(false, myq.isEmpty());
		
		try{
			myq = new CircularQueue<E>(10);
		} catch(Exception e){
			
		}
	}
	
	/**
	 * testAdd() will test the add() method.
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {

		myq = new CircularQueue<E>(0);
		assertEquals(true,myq.add(0));
	}
	
	/**
	 * testAddAll() will test the addAll method.
	 * @throws Exception
	 */
	@Test
	public void testAddAll() throws Exception {
		myq = new CircularQueue<E>(0);
		CircularQueue<E> myc = new CircularQueue<E>(0);
		try {
		    myq.addAll(myc);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testContains() tests the contains() method.
	 * @throws Exception
	 */
	@Test
	public void testContains() throws Exception {

		myq = new CircularQueue<E>(0);
		try {
		    myq.contains(1);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testContainsAll tests the containsAll() method. 
	 * @throws Exception
	 */
	@Test
	public void testContainsAll() throws Exception {
		myq = new CircularQueue<E>(0);
		CircularQueue<E> myc = new CircularQueue<E>(0);
		try {
		    myq.containsAll(myc);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testElement() tests the element() and clear() methods.
	 * @throws Exception
	 */
	@Test
	public void testElement() throws Exception {

		myq = new CircularQueue<E>(0);
		myq.offer(5);
		assertEquals(5,myq.element());
		
		try{
			myq.clear();
			myq.element();
		}catch(Exception NoSuchElementException){
			
		}
	}
	
	/**
	 * testGetRemainingQueueSpace() tests getRemainingQueueSpace() method.
	 * @throws Exception
	 */
	@Test
	public void testGetRemainingQueueSpace() throws Exception{
		myq = new CircularQueue<E>(0);
		assertEquals(1,myq.getRemainingQueueSpace());
	}
	
	/**
	 * testIterator() tests the iterator() method.
	 * @throws Exception
	 */
	@Test
	public void testIterator() throws Exception {
		myq = new CircularQueue<E>(0);
		try {
		    myq.iterator();
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testIsQueueFull() tests the isQueueFull() method.
	 * @throws Exception
	 */
	@Test
	public void testIsQueueFull() throws Exception{
		myq = new CircularQueue<E>(0);
		assertEquals(false, myq.isQueueFull());
		
		myq.offer(1);
		assertEquals(1,myq.getQueueCapacity());
		assertEquals(1,myq.size());
		assertEquals(true, myq.isQueueFull());
	}
	
	/**
	 * testOffer() tests the offer(), size(), and the peek() methods.
	 * @throws Exception
	 */
	@Test
	public void testOffer() throws Exception {
		myq = new CircularQueue<E>(0);
		
		assertEquals(1, myq.getQueueCapacity());
		assertEquals(0, myq.size());
		
		assertEquals(true, myq.offer(7));
		assertEquals(7, myq.peek());
		assertEquals(1, myq.getQueueCapacity());
		assertEquals(1, myq.size());
		
		assertEquals(true, myq.offer(8));
		assertEquals(7, myq.peek());
		assertEquals(2, myq.getQueueCapacity());
		assertEquals(2, myq.size());
		
		assertEquals(true, myq.offer(9));
		assertEquals(7, myq.peek());
		assertEquals(4, myq.getQueueCapacity());
		assertEquals(3, myq.size());
		
		assertEquals(true, myq.offer(10));
		assertEquals(7, myq.peek());
		assertEquals(4, myq.getQueueCapacity());
		assertEquals(4, myq.size());
		
		myq.setSize(0);
		assertEquals(0, myq.size());
		assertEquals(null, myq.peek());
	}
	
	/**
	 * testPoll() tests the poll() method.
	 * @throws Exception
	 */
	@Test
	public void testPoll() throws Exception {
		myq = new CircularQueue<E>(0);
	
		assertEquals(true, myq.offer(6));
		assertEquals(true, myq.offer(7));
		assertEquals(6,myq.poll());
	}
	
	/**
	 * testRemove() tests the remove() method.
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		myq = new CircularQueue<E>(0);
	
		assertEquals(true, myq.offer(6));
		assertEquals(true, myq.offer(7));
		assertEquals(6,myq.remove());
		assertEquals(7,myq.peek());
		
		try {
			myq.clear();
			myq.remove();
		} catch (Exception NoSuchElementException){
		}	
	}
	
	/**
	 * testRemoveObject() tests the remove() method.
	 * @param Object arg0
	 * @throws Exception
	 */
	@Test
	public void testRemoveObject() throws Exception {
		myq = new CircularQueue<E>(0);
		try {
		    myq.remove(1);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testRemoveAll() will test the removeAll() method.
	 * @param Collection<?> arg0
	 * @throws Exception
	 */
	@Test
	public void testRemoveAll() throws Exception {
		myq = new CircularQueue<E>(0);
		CircularQueue<E> myc = new CircularQueue<E>(0);
		try {
		    myq.removeAll(myc);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testRetainAll() tests the retainAll() method.
	 * @param Collection<?> arg0
	 * @throws Exception
	 */
	@Test
	public void testRetainAll() throws Exception {
		myq = new CircularQueue<E>(0);
		CircularQueue<E> myc = new CircularQueue<E>(0);
		try {
		    myq.retainAll(myc);
		} 
		catch (Exception UnsupportedOperationException) {	
		}   
	}
	
	/**
	 * testToArray() tests the toArray() method 
	 * @throws Exception
	 */
	@Test
	public void testToArray() throws Exception {
		myq = new CircularQueue<E>(0);
		Object[] mya;
		mya = myq.toArray();
		assertEquals(mya,myq.toArray());
	}
	
	/**
	 * testToArray2() tests the toArray() method.
	 * @throws Exception
	 */
	@Test
	public void testToArray2() throws Exception {
		myq = new CircularQueue<E>(0);
		myq.offer(1);
		myq.offer(2);
		myq.offer(3);
		myq.offer(4);
		try{
			Object[] mya = myq.toArray();
		} catch(Exception UnsupportedOperationException){
			
		}
	}
	
}
