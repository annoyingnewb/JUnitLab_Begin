package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test; 
import org.junit.rules.ExpectedException;

public class GiftCardTest {	
	
	@Test
	public void getIssuingStore() {
		double     balance;
		GiftCard   card;
		int       issuingStore;

		 issuingStore = 1337;
		 balance      = 100.00;
		 card = new GiftCard(issuingStore, balance);
		 assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void getBalance() {
		double     balance;
		GiftCard   card;
		int       issuingStore;
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}

	@Test
	public void deduct_RemainingBalance() {
		double     balance;
		GiftCard   card;
		int       issuingStore;
		String amount;
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		amount = "Remaining Balance: " + String.format("%6.2f", 90.00);
		assertEquals("deduct(10.00)", amount, card.deduct(10.00));
		}
	
	@Test
	public void deduct_amountDue() {
		double     balance;
		GiftCard   card;
		int       issuingStore;
		String amount = "-10.00";
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		amount = "Amount Due: " + String.format("%6.2f", 10.00);
		assertEquals("deduct(110.00)", amount, card.deduct(110.00));
		
	}
	
	@Test
	public void deduct_invalidTransaction() {
		double     balance;
		GiftCard   card;
		int       issuingStore;
		String amount = "Invalid";
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		amount = "Invalid Transaction";
		assertEquals("deduct(-20.00)", amount, card.deduct(-20.00));
		
	}

	@Test 
	public void constructor_IncorrectID_Low(){
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High(){
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
}
