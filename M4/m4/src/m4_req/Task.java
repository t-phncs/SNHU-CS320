package m4_req;


public class Task {
	private static String taskID;
	private String taskName;
	private String taskDescription;
	
	Task(String taskID, String taskName, String taskDescription) {
		uniqueTaskID(taskID);
		setTaskName(taskName);
		setTaskDescription(taskDescription);
	}
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		if (taskName == null) {
			throw new IllegalArgumentException("Task name cannot be null");
		} else if (taskName.length() > 20) {
			throw new IllegalArgumentException("Task name cannot be longer than 20 chars");
		}
		this.taskName = taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Task desciption cannot be null");
		} else if (taskDescription.length() > 50) {
			throw new IllegalArgumentException("Task description cannot be longer than 20 chars");
		}
		this.taskDescription = taskDescription;
	}
	
	public void uniqueTaskID(String taskID) {	
		if(taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be null");
		} else if (taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID cannot be longer than 10 chars");
		}
		Task.taskID = taskID;
	}

	public static String getTaskID() {
		return taskID;
	}
	
}
	
	
	
