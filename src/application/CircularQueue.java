package application;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ahmad and Michael
 * 
 */
public class CircularQueue<E> implements FixedSizeQueueInterface<E> {
	private int capacity;
	private E dataArray[];
	private int head;
	private int tail;
	private int size;

	/**
	 * This constructor will instantiate a new circular queue of the size given
	 * as an attribute.
	 * 
	 * @param maxQueueSize This is the capacity of the circular queue.
	 * @throws Exception An exception will be thrown if an invalid capacity is passed into the method.
	 */
	public CircularQueue(int maxQueueSize) throws Exception {
		super();
		if (maxQueueSize!=0)
		{
			throw new Exception("Queue capacity invalid.");
		}
		this.capacity = maxQueueSize+1;
		clear();  
	}
	
	public void setSize(int x){
		this.size = x;
	}

	@Override
	public boolean add(E arg0) {
		return offer(arg0);
	}

	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			return dataArray[head];
		}
	}
		
	@Override
	public boolean offer(E arg0) {
		boolean retVal = false;
		if (this.size == this.capacity) {
			reallocate();
		} 	
		this.size++;
		tail = (tail + 1) % capacity;
		this.dataArray[tail] = arg0;
		retVal = true;
		return retVal;
	}
	
	public void reallocate() {
		int newCapacity = 2 * this.capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = this.head;
		for (int i=0; i<this.size; i++){
			newData[i] = this.dataArray[j];
			j = (j+1) % this.capacity;
		}
		this.head = 0;
		this.tail = this.size - 1;
		this.capacity = newCapacity;
		this.dataArray= newData;
	}
	
	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return dataArray[head];
		}
	}

	@Override
	public E poll() {
		E retVal = null;
		if (size == 0) {
			// DO nothing.
		} else {
			retVal = dataArray[head];
			dataArray[head] = null;
			tail = (tail + 1) % capacity;
			size--;
		}
		return retVal;
	}

	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			E retVal = dataArray[head];
			dataArray[head] = dataArray[head+1];
			tail = (tail) % capacity;
			size--;
			
			return retVal;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		dataArray = ((E[]) new Object[capacity]);
		head = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean isEmpty() {
		if (this.size != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object retVal[] = new Object[size];

		for (int index = 0; index < size; index++) {
			int myOffset = (head + index) % this.capacity;
			retVal[index] = this.dataArray[myOffset];
		}
		return retVal;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int getQueueCapacity() {
		return this.capacity;
	}

	@Override
	public int getRemainingQueueSpace() {
		return this.capacity - this.size;
	}
	
	@Override
	public boolean isQueueFull() {
		return (this.size >= this.capacity);
	}

}
