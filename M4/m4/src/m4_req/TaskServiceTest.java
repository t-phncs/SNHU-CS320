package m4_req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	private TaskService taskService;
	String taskID = UUID.randomUUID().toString().replace("-","").substring(0,10);
	
	@BeforeAll
	public static void setUpAll() {
		System.out.println("Test");
	}
	
	@BeforeEach
    public void setup() {
       System.out.println("Instantiating Task Service");
       taskService = new TaskService();
    }
	
	@Test
	@DisplayName("Should be able to add task with unique ID")
	void shouldAddTask() {
		taskService.addTask(taskID, "Task Name", "Task Description");
		assertFalse(taskService.getAllTask().isEmpty());
		assertEquals(1, taskService.getAllTask().size());
	}
	
	@Test
	@DisplayName("Should be able to delete tasks per taskID")
	void shoudDeleteTask() {
		taskService.delete(Task.getTaskID());
		assertFalse(taskService.taskList.containsKey(Task.getTaskID()));
	}
	
	@Test
	@DisplayName("Should be able to update name")
	void shoudUpdateTaskName() {
		taskService.addTask(taskID, "Old Task Name", "Test Desc");
		assertTrue(taskService.updateTaskName(Task.getTaskID(), "New Task Name"));
	}
	
	@Test
	@DisplayName("Should be able to update task description")
	void shoudUpdateTaskDescription() {
		taskService.addTask(taskID, "Task Name", "Old Test Desc");
		assertTrue(taskService.updateTaskName(Task.getTaskID(), "New Task Description"));
	}
		
}
