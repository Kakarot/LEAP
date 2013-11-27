package test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.List;

import banking.Owner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import save.SaveState;

public class BankingTest {
	
	Owner newOwner=new Owner();
	

	@Before
	public void setUp() throws Exception {
		newOwner.getData();
	}

	@After
	public void tearDown() throws Exception {
		SaveState.storeState("Chris Simpkins", "830", "60", "1234");
	}

	@Test
	public void testLoadName() {
		assertEquals("Chris Simpkins", newOwner.getName());
	}
	@Test
	public void testLoadCheckingBalance() {
		assertEquals("830", newOwner.getCheckingBalance());
	}
	@Test
	public void testLoadSavingsBalance() {
		assertEquals("60", newOwner.getSavingsBalance());
	}
	@Test
	public void testLoadPIN() {
		assertEquals(1234, newOwner.getPin());
	}

	@Test
	public void testAddChecking() {
		
		newOwner.addChecking(new BigInteger("100"));
		assertEquals("930",newOwner.getCheckingBalance());
	}

	@Test
	public void testSubtractChecking() {
		newOwner.subtractChecking(new BigInteger("100"));
		assertEquals("730", newOwner.getCheckingBalance());
	}

	@Test
	public void testAddSavings() {
		newOwner.addSavings(new BigInteger("100"));
		assertEquals("160", newOwner.getSavingsBalance());
	}

	@Test
	public void testSubtractSavings() {
		newOwner.subtractSavings(new BigInteger("50"));
		assertEquals("10", newOwner.getSavingsBalance());
	}

	@Test
	public void testGetPin() {
		assertEquals(1234, newOwner.getPin());
	}

	@Test
	public void testChangePin() {
		newOwner.changePin((short)9876);
		assertEquals(9876, newOwner.getPin());
	}


	@Test
	public void testGetList() {
		List<String> fileData=newOwner.getList();
		assertEquals(newOwner.getName(), fileData.get(0));
		assertEquals(newOwner.getCheckingBalance(), fileData.get(1));
		assertEquals(newOwner.getSavingsBalance(), fileData.get(2));
		assertEquals(Short.toString(newOwner.getPin()), fileData.get(3));
	}

}
