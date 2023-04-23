package m4_req;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TaskService {
	Map<String, Task> taskList = new ConcurrentHashMap<>();
	
	
	public void addTask(String taskID, String taskName, String taskDescription) {
		taskID = UUID.randomUUID().toString().replace("-", "").substring(0,10);
		Task task = new Task(taskID, taskName, taskDescription);
		taskList.put(Task.getTaskID(), task);
	}
	
	public Collection<Task> getAllTask() {
		return taskList.values();
	}

	
	public void delete(String taskID) {
		taskList.remove(taskID);
	}
	
	public boolean updateTaskName(String taskID, String taskName) {
		Task task = taskList.get(taskID);
		//task.setTaskName(taskName);
		if (taskName == task.getTaskName()) {
			System.out.println("Name already exist!");
		} else if (taskName.compareTo(task.getTaskName()) < 0  || taskName.compareTo(task.getTaskName()) > 0) {
			task.setTaskName(taskName);
			return true;
		}
		return false;
	}
	
	public boolean updateTaskDescription(String taskID, String taskDesc) {
		Task task = taskList.get(taskID);
		//task.setTaskName(taskName);
		if (taskDesc == task.getTaskDescription()) {
			System.out.println("Name already exist!");
		} else if (taskDesc.compareTo(task.getTaskName()) < 0  || taskDesc.compareTo(task.getTaskName()) > 0) {
			task.setTaskName(taskDesc);
			return true;
		}
		return false;
	}
}
