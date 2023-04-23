package m5_req;

import java.util.Date;
import java.util.Objects;

public class Appointment {
	private static String apptID;
	private Date apptDate;
	private String apptDesc;
	
	Appointment(String apptID, Date apptDate, String apptDesc) {
		setApptID(apptID);
		setApptDate(apptDate);
		setApptDesc(apptDesc);
	}
	
	public static String getApptID() {
		return apptID;
	}
	public static void setApptID(String apptID) {
		if(apptID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be null!");
		} else if (apptID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID cannot be longer than 10 chars!");
		}
		Appointment.apptID = apptID;
	}
	public Date getApptDate() {
		return apptDate;
	}
	public void setApptDate(Date apptDate) {
		apptDate = new Date();
		long prevDay = System.currentTimeMillis() - 1000*60*60*24;
		Date prev = new Date(prevDay);
		
		if (Objects.isNull(apptDate)) {
			throw new IllegalArgumentException("Appointment Date cannot be null");
		} else {
			if (!prev.before(apptDate)) {
				throw new IllegalArgumentException("Appointment Date is in the past");
			} else {
				this.apptDate = apptDate;
			}
		}
		
	}
	
	public String getApptDesc() {
		return apptDesc;
	}
	public void setApptDesc(String apptDesc) {
		if(apptDesc == null) {
			throw new IllegalArgumentException("Description cannot be null!");
		} else if (apptDesc.length() > 50) {
			throw new IllegalArgumentException("Description cannot be longer than 50 chars!");
		}
		this.apptDesc = apptDesc;
	}
	
	
}
