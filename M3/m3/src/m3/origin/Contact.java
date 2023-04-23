package m3.origin;

public class Contact {
	private static String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	
	public Contact(String contactID, String firstName, String lastName, String number, String address) {
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
		uniqueID(contactID);
	}
	
	public String getContactID() {
		return contactID;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws IllegalArgumentException{
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be null");
		} else if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name cannot be longer than 10 character");
		} else {
			this.firstName = firstName;
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be null");
		} else if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot be longer than 10 character");
		} else 
			this.lastName = lastName;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		if (number == null) {
			throw new IllegalArgumentException("Phone number cannot null");
		} else if (number.length() != 10) {
			throw new IllegalArgumentException("Phone number cannot be exceed 10 digits or less");
		} else {
			this.Number = number;
		}		
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null");
		}
		else if (address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be longer than 30 character");
		} else
			this.Address = address;
	}
	
	public void uniqueID(String contactID) {
		if (contactID == null) {
			throw new IllegalArgumentException("Contact ID cannot be null");
		} else if (contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID cannot be more than 10 digits");
		} else {
			Contact.contactID = contactID;
		}
	}
}
