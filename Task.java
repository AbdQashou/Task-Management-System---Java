package data_final;

import java.util.Date;

public class Task {// Task class
	// Attributes for each task
	private String taskName;
	private Date taskDate;
	private String taskPriority;
	private String taskCategory;
	private boolean compleated;

	// constructor
	public Task(String taskName, Date taskDate, String taskPriority, String taskCategory) {
		// it dosen't give the completed attribute a value it stay false until we change it
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskPriority = taskPriority;
		this.taskCategory = taskCategory;
	}
	//Getters for the attributes
	public String getTaskName() {
		return taskName;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public boolean isCompleated() {
		return compleated;
	}
	//to set a value for completed
	public void setCompleated(boolean compleated) {
		this.compleated = compleated;
	}

}
