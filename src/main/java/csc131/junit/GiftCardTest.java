package csc131.junit;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test; 
import org.junit.rules.ExpectedException;

class GiftCardTest {

	@Test
	public void testGetIssuingStore() {
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
	
	public void deduct_RemainingBalance() {
		double     balance;
		GiftCard   card;
		int       issuingStore;
		String amount = "";
		
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct(20.00)", amount, card.deduct(20.00));
	}
	

}
