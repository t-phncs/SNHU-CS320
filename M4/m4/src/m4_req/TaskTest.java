package m4_req;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class TaskTest {
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test");
	}
	

	@Test
	@DisplayName("Task ID is longer than 10 char will throw errors")
	void testTaskID_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TestingMoreThan10Chars", "Task Name","Task Description");
		});
	}
	
	@Test
	@DisplayName("Task ID is null will throw errors")
	void testTaskID_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Name","Task Description");
		});
	}
	@Test
	@DisplayName("Task Name is longer than 20 chars will throw errors")
	void testTaskName_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TaskID1234", "Task Name More Than 20 Chars","Task Description");
		});
	}
	
	@Test
	@DisplayName("Task Name is null will throw errors")
	void testTaskName_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TaskID1234", null,"Task Description");
		});
	}
	
	@Test
	@DisplayName("Task Description is longer than 50 chars will throw errors")
	void testTaskDesc_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TaskID1234", "Task Name","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam varius quis massa non elementum. Mauris lorem nisl, interdum tristique sodales in");
		});
	}
	
	@Test
	@DisplayName("Task Description is null will throw errors")
	void testTaskDesc_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("TaskID1234", null,null);
		});
	}
	

}
