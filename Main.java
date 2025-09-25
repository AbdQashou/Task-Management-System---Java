package data_final;

public class Main {

	public static void main(String[] args) {

		TaskManager tasks = new TaskManager();

		tasks.addTask("aa", "2024-7-10", "Normal", "Study");
		tasks.addTask("bb", "2021-1-3", "Normal", "Work");
		tasks.addTask("cc", "2021-8-15", "Normal", "Work");
		tasks.addTask("dd", "2021-7-15", "Normal", "Work");
		tasks.addTask("ee", "2021-7-10", "Normal", "Work");
		tasks.addTask("ff", "2023-2-10", "Urgent", "Personal");
		tasks.addTask("gg", "2016-12-15", "Urgent", "Work");
		tasks.addTask("hh", "2029-1-7", "Normal", "Personal");
		tasks.addTask("ii", "2014-9-4", "Urgent", "Study");
		tasks.addTask("jj", "2022-7-2", "Normal", "Study");
		tasks.addTask("kk", "2015-9-4", "Urgent", "Study");

		System.out.println();

		tasks.displayOrderedTasks();
		System.out.println();

		tasks.displayUrgentTasks();
		System.out.println();

		tasks.displayTaskBasedOnCategory("Study");
		System.out.println();

		tasks.setCompleted("aa");
		tasks.setCompleted("ii");
		tasks.setCompleted("ee");
		tasks.setCompleted("kk");

		tasks.displayCompletedTasks();
		System.out.println();

		tasks.displayOrderedTasks();
		System.out.println();

		tasks.displayUrgentTasks();
		System.out.println();

		tasks.displayTaskBasedOnCategory("Study");
		System.out.println();

	}

}
