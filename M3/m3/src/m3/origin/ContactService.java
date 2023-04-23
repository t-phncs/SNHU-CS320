package m3.origin;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
	Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();
	String id = UUID.randomUUID().toString().replace("-","").substring(0,10);
//	public static String uniqueID() {
//		String id = UUID.randomUUID().toString().replace("-", "").substring(1,11);	
//		return id;
//	}
	
	public void addContact(String id, String firstName, String lastName, String number, String address) {
		Contact contact = new Contact(id, firstName, lastName, number, address);
		contactList.put(generateKey(contact), contact);
	}
	
	public Collection<Contact> getAllContacts() {
		return contactList.values();
	}
	
	public void delete(Contact contact) {
		if(contactList.containsKey(generateKey(contact))) {
			contactList.remove(generateKey(contact), contact);
		}
	}

	private String generateKey(Contact contact) {
		return String.format("%s-%s-%s-%s", contact.getFirstName(), 
				contact.getLastName(), contact.getNumber(), contact.getAddress());
	}
	
	public void updateFirstName(String newFirstName, Contact contact) {
		
		if (contactList.containsKey(contact.getFirstName()))
            throw new RuntimeException("First Name Already Exists");
		else
			contactList.replace(newFirstName, contact);
	}
	
	public void updateLastName(Contact contact) {
		String newLastName = "Doe";
		if (contactList.containsKey(contact.getLastName()))
            throw new RuntimeException("Last Name Already Exists");
		else
			contactList.replace(newLastName, contact);
	}
	
	public void updateNumber(Contact contact) {
		String newNumber = "0011223344";
		if (contactList.containsKey(contact.getNumber()))
            throw new RuntimeException("Number Already Exists");
		else
			contactList.replace(newNumber, contact);
	}
	
	public void updateAddress(Contact contact) {
		String newAddress = "4321 Miso Avenue";
		if (contactList.containsKey(contact.getAddress()))
            throw new RuntimeException("Address Already Exists");
		else
			contactList.replace(newAddress, contact);
	}
}