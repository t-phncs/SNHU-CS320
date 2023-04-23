package m3.origin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ContactService contactService;
	String id = UUID.randomUUID().toString().replace("-","").substring(0,10);

	@BeforeAll
	public static void setUpAll() {
		System.out.println("Test");
	}
	
	@BeforeEach
    public void setup() {
        System.out.println("Instantiating Contact Service");
        contactService = new ContactService();
    }
	@Test
	@DisplayName("Should be able to add contact")
	void shouldCreateContact() {
		contactService.addContact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		assertFalse(contactService.getAllContacts().isEmpty());
		assertEquals(1, contactService.getAllContacts().size());
	}
	
	@Test
	@DisplayName("Should be able to remove contact")
	void shouldDeleteContact() {
		Contact ct = new Contact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		contactService.delete(ct);
	}
	
	@Test
	@DisplayName("Should be able to update contact - firstName") 
	void shouldUpdateContactForFirstName() {
		String newName = "John";
		Contact ct = new Contact(id, newName, "Phan", "0123456789", "1234 Convoy Street");
		//contactService.addContact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		contactService.updateFirstName(newName, ct);
	}
	
	@Test
	@DisplayName("Should be able to update contact - lastName") 
	void shouldUpdateContactForLastName() {
		String newName = "Sample";
		Contact ct = new Contact(id, "Tam", newName, "0123456789", "1234 Convoy Street");
		//contactService.addContact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		contactService.updateFirstName(newName, ct);
	}
	
	@Test
	@DisplayName("Should be able to update contact - Number") 
	void shouldUpdateContactForNumber() {
		String newNumber = "0011223344";
		Contact ct = new Contact(id, "Tam", "Phan", newNumber, "1234 Convoy Street");
		//contactService.addContact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		contactService.updateFirstName(newNumber, ct);
	}
	
	@Test
	@DisplayName("Should be able to update contact - Address") 
	void shouldUpdateContactForAddress() {
		String newAddress = "1234 Miso Avenue";
		Contact ct = new Contact(id, "Tam", "Phan", "0123456789", newAddress);
		//contactService.addContact(id, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		contactService.updateFirstName(newAddress, ct);
	}
}
