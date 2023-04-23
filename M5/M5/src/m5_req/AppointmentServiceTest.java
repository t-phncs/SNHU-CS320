package m5_req;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	private AppointmentService apptService;
	String apptID = UUID.randomUUID().toString().replace("-","").substring(0,10);
	Date current = new Date();
	
	
	@BeforeAll
	public static void setUpAll() {
		System.out.println("Test");
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("Instantiating Appointment Service");
		apptService = new AppointmentService();
	}
	@Test
	@DisplayName("Should be able to add appt with appt unique ID")
	void shouldAddAppt() {
		apptService.addAppt(apptID, current, "Appointment Description");
		assertFalse(apptService.getAllAppt().isEmpty());
		assertEquals(1, apptService.getAllAppt().size());
	}
	
	@Test
	@DisplayName("Should be able to delete appt per appt ID")
	void shouldDeleteApptID() {
		apptService.delete(Appointment.getApptID());
		assertFalse(apptService.apptList.containsKey(Appointment.getApptID()));
	}
	
	

}
