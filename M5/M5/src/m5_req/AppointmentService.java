package m5_req;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AppointmentService {
	Map<String, Appointment> apptList = new ConcurrentHashMap<>();
	
	public void addAppt(String apptID, Date apptDate, String apptDesc) {
		apptID = UUID.randomUUID().toString().replace("-","").substring(0,10);
		Appointment appt = new Appointment(apptID, apptDate, apptDesc);
		apptList.put(Appointment.getApptID(), appt);
	}
	
	public Collection<Appointment> getAllAppt() {
		return apptList.values();
	}
	
	public void delete(String apptID) {
		apptList.remove(apptID);
	}
}
