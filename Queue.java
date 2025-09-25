package data_final;

public class Queue {
	// attributes
	private Task[] circularArray;
	private int arraySize;
	private int front, rear;
	private int elementsCounter;

	// constructor
	public Queue() {

		arraySize = 10;
		this.circularArray = new Task[arraySize];
		this.front = -1;
		this.rear = -1;
		this.elementsCounter = 0;
	}

	public boolean isEmpty() {
		return (elementsCounter == 0);

	}

	public boolean isFull() {
		return (arraySize == elementsCounter);

	}

	public void enqueue(Task value) {
		if (isFull()) {
			// resizing the array
			arraySize *= 2;
			Task[] array1 = new Task[arraySize];

			for (int i = 0; i < circularArray.length; i++) {
				array1[i] = circularArray[i];
			}
			circularArray = array1;// pointer

		}
		if (isEmpty()) {

			front = 0;
			rear = 0;
			elementsCounter++;
			circularArray[rear] = value;
			return;
		}
		rear = (rear + 1) % arraySize;
		circularArray[rear] = value;
		elementsCounter++;

	}

	public Task dequeue() {

		Task deleted = circularArray[front];

		if (isEmpty()) {
			System.out.println("No completed Tasks!!");
		}
		if (front == rear) {
			rear = front = -1;
		} else {
			front = (front + 1) % arraySize;
		}
		elementsCounter--;
		return deleted;

	}

	public Task nextToOut() {
		if (isEmpty()) {
			System.out.println("Empty list!");
		}
		return circularArray[front];
	}

	public void clear() {
		rear = front = -1;
		elementsCounter = 0;
	}

	// to get the content of the queue(get circularArray)
	public Task[] printContent() {
		if (isEmpty()) {
			System.out.println("There are NO completed Tasks!!");
		}

		return circularArray;
	}

}
