package data_final;

import java.text.SimpleDateFormat;

public class LinkedList {
	// Node class
	public class Node {
		// Attributes
		private Task data;
		private Node nextLocation;

		// Constructor
		public Node(Task data) {
			this.data = data;
			this.nextLocation = null;
		}

	}

	// attributes
	private int counter = 0;
	private Node head = null;
	// objects from different class to use below
	Queue completedTasks = new Queue();
	Stack urgentTasks = new Stack();
	// an object to chose the format of dates
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	// insert method
	public void insert(Task data) {
		Node newNode = new Node(data);
		counter++;
		// if the task is urgent add it to the stack
		if (newNode.data.getTaskPriority() == "Urgent") {

			urgentTasks.push(data);

		}
		// if the stack is empty make the head = newNode
		if (isEmpty()) {
			head = newNode;
			// System.out.println("you added the task: " + head.data.getTaskName());

			return;
		}

		// compareTo is a method in the Date class that returns a negative number
		// if the date is earlier and zero if it is the same and a positive number if it
		// is later.

		// the below comparing by date is to Sort the tasks by their due dates once we
		// need to insert a new task

		// if the new task earlier than the head case
		if (newNode.data.getTaskDate().compareTo(head.data.getTaskDate()) < 0) {
			insertAtFirst(newNode.data);
			// System.out.println("you added the task: " + head.data.getTaskName());
			return;

		}
		// find the correct position for the task then add it
		Node current = head;
		while (current.nextLocation != null
				&& current.nextLocation.data.getTaskDate().compareTo(newNode.data.getTaskDate()) < 0) {

			current = current.nextLocation;
		}
		// adding the new task
		newNode.nextLocation = current.nextLocation;
		current.nextLocation = newNode;
		// System.out.println("You added the task: " + newNode.data.getTaskName());
	}

	// print method to print all the tasks by order that did'nt finished yet
	public void print() {
		// if the list is empty case
		if (isEmpty()) {
			System.out.println("There are NO tasks added!!");
			return;
		}
		Node current = head;
		// printing tasks
		while (current != null) {
			String date = dateFormat.format(current.data.getTaskDate());

			System.out.println(current.data.getTaskName() + " |" + date + " |" + current.data.getTaskPriority() + " |"
					+ current.data.getTaskCategory());

			current = current.nextLocation;

		}
	}

	// setFinished method to find the needed task and set it as finished
	public void setFinished(String taskName) {
		// if the list is empty case
		if (isEmpty()) {
			System.out.println("There are NO tasks added!!");
			return;

		}
		// find the needed task
		Node current = head;

		while (current != null) {
			if (current.data.getTaskName() == taskName) {
				current.data.setCompleated(true);
				completedTasks.enqueue(current.data);// add the completed task to the queue that holds the completed
														// tasks
				remove(current.data.getTaskName());// remove it from the list
				if (current.data.getTaskPriority() == "Urgent") {
					urgentTasks.removeSpecificData(taskName);

				}
				return;
			}
			current = current.nextLocation;

		}

		// if the given task name is wrong
		System.out.println("There is NO task with this name!!");

	}

	// to print the completed tasks from queue, the one that finished first print it
	// first
	public void printCompletedTasks() {
		// the array below to hold the data that returned from the printContent method
		// from queue
		Task[] array = completedTasks.printContent();
		for (int i = 0; array[i] != null; i++) {
			Task task = array[i];
			String date = dateFormat.format(task.getTaskDate());// change the format of the date to (yyyy-mm-dd)

			System.out.println(
					task.getTaskName() + " |" + date + " |" + task.getTaskPriority() + " |" + task.getTaskCategory());
		}
	}

	// to print the urgent tasks from stack, the last urgent task added print it
	// first
	public void printUrgentTasks() {
		// save the data that returned from getArrayand getTop methods from the stack
		Task[] array = urgentTasks.getArray();
		int count = urgentTasks.getTop();
		// loop on the count which is the top
		while (count != -1) {
			Task task = array[count];
			String date = dateFormat.format(task.getTaskDate());// change the date format

			System.out.println(
					task.getTaskName() + " |" + date + " |" + task.getTaskPriority() + " |" + task.getTaskCategory());
			count--;
		}
	}

	// to print the tasks based on category
	public void printOnCategory(String categoryName) {

		Node current = head;
		// loop on the list
		while (current != null) {
			Task task = current.data;
			if (task.getTaskCategory() == categoryName) {
				String date = dateFormat.format(task.getTaskDate());// change the date format

				System.out.println(task.getTaskName() + " |" + date + " |" + task.getTaskPriority() + " |"
						+ task.getTaskCategory());
			}
			current = current.nextLocation;

		}
	}

	public void insertAtFirst(Task data) {
		Node newNode = new Node(data);
		counter++;

		if (isEmpty()) {
			head = newNode;
			return;
		}
		newNode.nextLocation = head;
		head = newNode;

	}

	// remove at
	public void remove(String taskName) {

		// Exception Handling example
		if (head.data.getTaskName() == taskName) {
			if (head.nextLocation == null) {
				head = null;
			} else {
				head = head.nextLocation;
			}
			counter--;
			return;
		}
		Node current = head;

		while (current.nextLocation != null) {
			if (current.nextLocation.data.getTaskName() == taskName) {
				current.nextLocation = current.nextLocation.nextLocation;
				counter--;

				return;
			}
			current = current.nextLocation;

		}

	}

	public void removeAtEnd() {
		counter--;
		Node curent = head;

		if (isEmpty()) {
			System.out.println("Empty List..!");
		}
		if (size() == 1) {
			head = null;
			counter--;
		}
		while (curent.nextLocation.nextLocation != null) {
			curent = curent.nextLocation;
		}
		curent.nextLocation = null;

	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int size() {
		return counter;
	}

}
