import deque.DynamicArrayDeque;
import queue.DynamicArrayQueue;
import stack.DynamicArrayStack;

public class Demo {

	public static void main(String[] args) {
		
		DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<Integer>();
		DynamicArrayStack<Integer> stack = new DynamicArrayStack<Integer>();
		DynamicArrayDeque<Integer> dequeS1 = new DynamicArrayDeque<Integer>(); 
		DynamicArrayDeque<Integer> dequeS2 = new DynamicArrayDeque<Integer>();
		DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<Integer>();
		DynamicArrayDeque<Integer> dequeQ1 = new DynamicArrayDeque<Integer>();
		DynamicArrayDeque<Integer> dequeQ2 = new DynamicArrayDeque<Integer>();
		
		//insert elements 
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				deque.addFirst(i);	//adding element to the front of the deque
			} else {
				deque.addLast(i);	//adding element to the back of the deque
			}
			stack.push(i); 			//pushing element to the top of the stack
			dequeS1.addFirst(i);	//adding element to the front of the deque
			dequeS2.addLast(i);		//adding element to the back of the deque
			queue.enqueue(i);		//adding element to the end of the queue
			dequeQ1.addFirst(i);	//adding element to the front of the deque
			dequeQ2.addLast(i);		//adding element to the back of the deque
		}
		
		//Deque
		System.out.println("Deque: ");
		while(!deque.isEmpty()) {
			System.out.println(deque.removeFirst());
      //System.out.println(deque.removeLast());
		}
		
		//Stack
		System.out.println("Stack: ");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		//Deque is used as a Stack by adding and removing from the front
		System.out.println("Deque as a Stack (1): ");
		while(!dequeS1.isEmpty()) {
			System.out.println(dequeS1.removeFirst());
		}
		
		//Deque is used as a Stack by adding and removing from the back
		System.out.println("Deque as a Stack (2): ");
		while(!dequeS2.isEmpty()) {
			System.out.println(dequeS2.removeLast());
		}
		
		//Queue
		System.out.println("Queue: ");
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
		//Deque is used as a Queue by adding to the front and removing from the back
		System.out.println("Deque as a Queue (1): ");
		while(!dequeQ1.isEmpty()) {
			System.out.println(dequeQ1.removeLast());
		}
		
		//Deque is used as a Queue by adding to the back and removing from the front
		System.out.println("Deque as a Queue (2): ");
		while(!dequeQ2.isEmpty()) {
			System.out.println(dequeQ2.removeFirst());
		}

	}

}
