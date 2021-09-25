import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BMS.CheckingAccount;

public class CheckingAccountTest {

	private CheckingAccount ObjectChecking;
	private CheckingAccount ObjectChecking2;
	
	@Before
	public void setUp() throws Exception {
		ObjectChecking = new CheckingAccount();
		ObjectChecking2 = new CheckingAccount();
	}

	@After
	public void setUpA() throws Exception {
		System.out.println(" \n *** The 'Test'  has been executed successfully !!! *** ");
	}
	
	/* I am testing all the functionalities of Checking Account in a single test */
	@Test
	public void TestingAllFunctionsofChecking() {
		
		ObjectChecking.SetBalance(57000);
		ObjectChecking.SetName("Adeeba Khan");
		ObjectChecking.SetAccountNo();
		
		ObjectChecking2.SetBalance(90000);
		ObjectChecking2.SetName("Muneeba Khan");
		ObjectChecking2.SetAccountNo();
		
		/* Checking Deposit */ 
		ObjectChecking.MakeDeposit(ObjectChecking, 15000);
		ObjectChecking2.MakeDeposit(ObjectChecking2, 5000);
		
		float result = ObjectChecking.GetBalance();
		float result2 = ObjectChecking2.GetBalance();
		float expectedresult = 72000;
		float expectedresult2 = 95000;
		
		Assert.assertEquals(expectedresult,result,0);
		Assert.assertEquals(expectedresult2,result2,0);
		
		/* Checking Withdrawal */
		ObjectChecking.WithdrawAmount(ObjectChecking, 7000);
		ObjectChecking2.WithdrawAmount(ObjectChecking2, 3000);
		
		float result3 = ObjectChecking.GetBalance();
		float expectedresult3 = 65000;
		
		float result4 = ObjectChecking2.GetBalance();
		float expectedresult4 = 92000;
		
		Assert.assertEquals(expectedresult3,result3,0);
		Assert.assertEquals(expectedresult4,result4,0);
		
		/* Checking Print Statement */
		ObjectChecking.PrintStatement(ObjectChecking);
		ObjectChecking2.PrintStatement(ObjectChecking2); 
		
		/* Checking Transfer Amount */
		ObjectChecking.TransferAmount(ObjectChecking2, 7000, ObjectChecking);
		
		float result5 = ObjectChecking.GetBalance();
		float expectedresult5 = 58000;
		
		float result6 = ObjectChecking2.GetBalance();
		float expectedresult6 = 99000;
		
		Assert.assertEquals(expectedresult5,result5,0);
		Assert.assertEquals(expectedresult6,result6,0); 
		
		
		/* Checking Tax Calculation */
		ObjectChecking.WithdrawAmount(ObjectChecking, 7000);
		ObjectChecking.MakeDeposit(ObjectChecking, 15000);
		ObjectChecking.MakeDeposit(ObjectChecking, 15000);
		
		float tax = ObjectChecking.GetTax();
		
		float expectedresult7 = 20;
		float expectedresult8 = 10;
		Assert.assertEquals(expectedresult7,tax,0);
		Assert.assertNotEquals(expectedresult8,tax,0);
	}

}
