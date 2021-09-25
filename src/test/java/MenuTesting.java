import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import BMS.BankManagementSystem;
import BMS.CustomerInfo;

public class MenuTesting {

	private BankManagementSystem ObjectBMS;
	
	@Before
	public void setUp() throws Exception {
		
		ObjectBMS = new BankManagementSystem();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TestMenu() {
	
		Boolean check = ObjectBMS.BankMenu(); /* Press 0 in the console to end the menu at once. 
		                                         The more you check the menu, the more coverage it will give */
		Assert.assertTrue(check);
		
	}

}
