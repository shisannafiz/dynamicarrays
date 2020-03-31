package queue;

public class DynamicArrayQueue<AnyType> implements Queue<AnyType> {
	
	public static final int DEFAULT_CAPACITY = 2;
	
	private int front;
	private int theSize;
	AnyType[] data;
	
	public DynamicArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public DynamicArrayQueue(int capacity) {
	  	front = 0;
	  	theSize = 0;
	  	data = (AnyType[]) new Object[capacity];
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return theSize == 0;
	}
	
	private void resizeMore(int newCapacity) {
		int n = size();
		int back = (front + theSize - 1) % data.length; 
		AnyType[] temp = (AnyType[]) new Object[newCapacity]; 
		
		if (front == 0) {
			int index = 0;
			for (int i = front; i < n; i++) {
				temp[index] = data[i];
				index++; 
			}
		} else {
			int index = 0;
			for (int i = front; i < n; i++) {
				temp[index] = data[i];
				index++;
			}
			for (int i = 0; i <= back; i++) {
				temp[index] = data[i]; 
				index++;
			}
		}
		front = 0;
		data = temp;
		return;
	 }
	  
	private void resizeLess(int newCapacity) {
		int n = size();
		int back = (front + theSize - 1) % data.length; 
		AnyType[] temp = (AnyType[]) new Object[newCapacity]; 
		
		if (front < back) {
			int index = 0;
			for(int i = front; i <= back; i++) {
				temp[index] = data[i];
				index++;
			}
		} else if (front > back){
			int index = 0;
			for (int i = front; i < n; i++) {
				temp[index] = data[i];
				index++;
			}
			for (int i = 0; i <= back; i++) {
			  temp[index] = data[i]; 
			  index++;
			}
		} else {
			temp[0] = data[front];
			back = (front + theSize) % data.length;
		}
		front = 0;
		data = temp;
		return;
	}
	
	public void enqueue(AnyType newValue) {
		if (theSize == data.length) resizeMore(theSize * 2);
		
		int back = (front + theSize) % data.length; 
		data[back] = newValue;
		theSize++;
	}
	
	public AnyType first() throws IllegalStateException {
		if (theSize == 0) throw new IllegalStateException();
		  
		return data[front];	
	}
	
	public AnyType dequeue() throws IllegalStateException {
		if (theSize == 0) throw new IllegalStateException();
		if (theSize <= (data.length / 4)) resizeLess(data.length / 2);	
		  
		AnyType temp = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		theSize--;
		return temp;	
	}

}
