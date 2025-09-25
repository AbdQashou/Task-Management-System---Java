package data_final;

public class Stack {

	private Task array[];
	private int top;
	private int size;

	// constructor
	public Stack() {// first in last out

		size = 10;
		array = new Task[size];
		top = -1;
	}

	// methods------------

	public Task[] getArray() {
		return array;
	}

	public int getTop() {
		return top;
	}

	public Task top() {
		return array[top];
	}

	boolean isEmpty() {
		return (top == -1);

	}

	public void push(Task value) {

		// is full function((
		if (top >= size - 1) {
			size *= 2;
			Task[] array1 = new Task[size];

			for (int i = 0; i < array.length; i++) {
				array1[i] = array[i];
			}
			array = array1;
		}
		// )))

		top++;
		array[top] = value;
	}

	public void pop() {
		top--;
	}

	public void removeSpecificData(String taskName) {

		// find the needed task
		int index = -1;
		for (int i = 0; i <= top; i++) {
			if (array[i].getTaskName() == taskName) {
				index = i;
			}
		}

		// out if the task is not found
		if (index == -1) {
			return;
		}

		// Shifting to remove the needed task
		for (int i = index; i < top; i++) {
			array[i] = array[i + 1];
		}

		top--;
	}

}
