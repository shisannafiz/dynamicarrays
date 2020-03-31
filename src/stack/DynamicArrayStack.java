package stack;

public class DynamicArrayStack<AnyType> implements Stack<AnyType> {
	
	public static final int DEFAULT_CAPACITY = 2;

	private int topOfStack;
	private AnyType[] data;
	
	public DynamicArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public DynamicArrayStack(int capacity) {
	  	topOfStack = -1;
	  	data = (AnyType[]) new Object[capacity];
	}
	
	public int size() {
		return topOfStack + 1;
	}

	public boolean isEmpty() {
		return topOfStack == -1;
	}
	
	private void resize(int newCapacity) {
		int n = size();
		AnyType[] temp = (AnyType[]) new Object[newCapacity];
		for(int i = 0; i < n; i++) temp[i] = data[i];
		data = temp;
	}

	public void push(AnyType newValue) {
		if(size() == data.length) resize(data.length * 2);
		
		topOfStack++;
		data[topOfStack] = newValue;
	}

	public AnyType top() throws IllegalStateException {
		if(topOfStack == -1) throw new IllegalStateException();
		return data[topOfStack];
	}

	public AnyType pop() throws IllegalStateException {
		if(topOfStack == -1) throw new IllegalStateException();
		
		if (size() <= data.length / 4) resize(data.length / 2);

		AnyType temp = data[topOfStack];
		data[topOfStack] = null;
		topOfStack--;
		return temp;
	}

}
