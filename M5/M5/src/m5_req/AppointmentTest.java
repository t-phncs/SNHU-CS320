package m5_req;


import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	Date current = new Date();
	Date oldDate = new Date(System.currentTimeMillis() - 1000*60*60*24);
	
	String apptID = UUID.randomUUID().toString().replace("-","").substring(0,10);
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test");
	}
	@Test
	@DisplayName("Appt ID is longer than 10 char will throw errors")
	void testApptID_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("TestingMoreThan10Chars", current, "Appt Description");
		});
	}
	
	@Test
	@DisplayName("Appt ID is null will throw errors")
	void testApptID_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, current, "Appt Description");
		});
	}
	
	@Test
	@DisplayName("Appt Date is null will throw errors")
	void testApptDate_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, null, "Appt Description");
		});
	}
	
	@Test
	@DisplayName("Appt Date is older than current date will throw errors")
	void testApptDate_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, oldDate, "Appt Description");
		});
	}
	
	@Test
	@DisplayName("Appt Description is null will throw errors")
	void testApptDesc_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, current, null);
		});
	}
	
	@Test
	@DisplayName("Appt Description exceed 50 chars will throw errors")
	void testApptDesc_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, current, "Appt Description, \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam varius quis massa non elementum.");
		});
	}


}
