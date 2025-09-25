package data_final;

import java.util.Date;

import java.text.*;

public class TaskManager {
	// object
	LinkedList tasksList = new LinkedList();

	// add task
	public void addTask(String taskName, String taskDate, String taskPriority, String taskCategory) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;

		// Exception Handling example
		// if the user entered the date not in the needed format
		try {
			date = dateFormat.parse(taskDate);
		} catch (ParseException e) {
			System.out.println("Invalid date format, Please use yyyy-mm-dd.");
			return;
		}

		Task task = new Task(taskName, date, taskPriority, taskCategory);
		tasksList.insert(task);

	}

	public void displayOrderedTasks() {
		System.out.println("All tasks ordered by thier due date >>");
		tasksList.print();
	}

	public void setCompleted(String taskName) {

		tasksList.setFinished(taskName);
	}

	public void displayCompletedTasks() {
		System.out.println("Completed Tasks >> ");

		tasksList.printCompletedTasks();

	}

	public void displayUrgentTasks() {
		System.out.println("Urgent Tasks >> ");

		tasksList.printUrgentTasks();

	}

	public void displayTaskBasedOnCategory(String name) {

		System.out.println("All tasks from: " + name + " Category");
		tasksList.printOnCategory(name);
	}

}
