package m3.origin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test");
	}
	

	@Test
	@DisplayName("Should not create contact when contact ID is longer than 10 char")
	void testSetContactID_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123234243234", "Tam", "Phan", "0123456789", "1234 Convoy Street");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when contact ID is null")
	void testSetContactID_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Tam", "Phan", "0123456789", "1234 Convoy Street");
		});
	}


	
	@Test
	@DisplayName("Should not create contact when first name is null")
	void testSetFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", null, "Phan", "0123456789", "1234 Convoy Street");
		});
	}
	@Test
	@DisplayName("Should not create contact when first name is more than 10 char")
	void testSetFirstName1() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam00000000000000000", "Phan", "0123456789", "1234 Convoy Street");
		});
	}

	@Test
	@DisplayName("Should not create contact when last name is more than 10 char")
	void testSetLastName_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", "Phan0000000000", "0123456789", "1234 Convoy Street");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when last name is more than 10 char")
	void testSetLastName_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", null, "0123456789", "1234 Convoy Street");
		});
	}
	

	@Test
	@DisplayName("Should not create contact when number is more than 10 char")
	void testSetNumber_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", "Phan", "01234567891", "1234 Convoy Street");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when number is null")
	void testSetNumber_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", "Phan", null, "1234 Convoy Street");
		});
	}

	@Test
	@DisplayName("Should not create contact when address is more than 30 char")
	void testSetAddress_case1() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", "Phan", "0123456789", "1234 Convoy Street-0000000000000000");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when address is null")
	void testSetAddress_case2() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1010101010", "Tam", "Phan", "0123456789", null);
		});
	}

}

