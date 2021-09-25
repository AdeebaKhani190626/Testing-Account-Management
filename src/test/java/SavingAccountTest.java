import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BMS.SavingAccount;

public class SavingAccountTest {
	
	private SavingAccount ObjectSaving;
	private SavingAccount ObjectSaving2;
	
	@Before
	public void setUp() throws Exception {
		ObjectSaving = new SavingAccount();
		ObjectSaving2 = new SavingAccount();
	}
	
	@After
	public void setUpA() throws Exception {
		System.out.println(" \n *** The 'Test'  has been executed successfully !!! *** ");
	}

	/* I am testing all the functionalities of Saving Account in multiple tests */
	/* Deposit Testing */
	@Test
	public void TestMakeDeposit() {
		
		float amount = 200;
		ObjectSaving.MakeDeposit(ObjectSaving, amount);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 200;
		Assert.assertEquals(expectedresult,result,0);
	}
	
	@Test
	public void TestMakeDepositNegative() {
		
		float amount = 200;
		ObjectSaving.MakeDeposit(ObjectSaving, amount);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 300;
		Assert.assertNotEquals(expectedresult,result,0);
	}
	
	/* Withdraw Testing */
	@Test
	public void TestWithdrawAmount() {
		
		ObjectSaving.SetBalance(700);
		float amount = 200;
		ObjectSaving.WithdrawAmount(ObjectSaving, amount);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 500;
		Assert.assertEquals(expectedresult,result,0);	
	}
	
	@Test
	public void TestWithdrawAmountNegative() {
		
		ObjectSaving.SetBalance(700);
		float amount = 200;
		ObjectSaving.WithdrawAmount(ObjectSaving, amount);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 777;
		Assert.assertNotEquals(expectedresult,result,0);	
	}
	
	/* Check Balance */
	@Test
	public void TestCheckBalance() {
		
		ObjectSaving.SetBalance(50000);
		ObjectSaving.SetName("Sara Khan");
		ObjectSaving.CheckBalance(ObjectSaving);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 50000;
		Assert.assertEquals(expectedresult,result,0);	
	}
	
	/* Zakat */
	@Test
	public void TestZakat() {
		
		ObjectSaving.SetBalance(999999);
		ObjectSaving.CalculateZakat(ObjectSaving);
		double result = ObjectSaving.GetZakat();
		double expectedresult = 24999.975;
		Assert.assertEquals(expectedresult,result,0);	
	}
	
	@Test
	public void TestZakatNegative() {
		
		ObjectSaving.SetBalance(999999);
		ObjectSaving.CalculateZakat(ObjectSaving);
		double result = ObjectSaving.GetZakat();
		double expectedresult = 24.975;
		Assert.assertNotEquals(expectedresult,result,0);	
	}
	
	/* Interest */
	@Test
	public void TestInterest() {
		
		ObjectSaving.SetBalance(45000);
		ObjectSaving.CalculateInterest(ObjectSaving, 10.1);
		double result = ObjectSaving.GetInterest();
		double expectedresult = 4545;
		Assert.assertEquals(expectedresult,result,0);	
	}
	
	@Test
	public void TestInterestNegative() {
		
		ObjectSaving.SetBalance(45000);
		ObjectSaving.CalculateInterest(ObjectSaving, 10.1);
		double result = ObjectSaving.GetInterest();
		double expectedresult = 454567;
		Assert.assertNotEquals(expectedresult,result,0);	
	}
	
	/* Transfer Amount */
	@Test
	public void TestTransferAmount() {
		
		ObjectSaving.SetBalance(80000);
		ObjectSaving2.SetBalance(10000);
		ObjectSaving.TransferAmount(ObjectSaving2, 40000, ObjectSaving);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 40000;
		float result2 = ObjectSaving2.GetBalance();
		float expectedresult2 = 50000;
		
		Assert.assertEquals(expectedresult,result,0);
		Assert.assertEquals(expectedresult2,result2,0);
	}
	
	@Test
	public void TestTransferAmountNegative() {
		
		ObjectSaving.SetBalance(80000);
		ObjectSaving2.SetBalance(10000);
		ObjectSaving.TransferAmount(ObjectSaving2, 40000, ObjectSaving);
		float result = ObjectSaving.GetBalance();
		float expectedresult = 468000;
		float result2 = ObjectSaving2.GetBalance();
		float expectedresult2 = 57000;
		
		Assert.assertNotEquals(expectedresult,result,0);
		Assert.assertNotEquals(expectedresult2,result2,0);
	}
	
	/* Print Statement */
	@Test
	public void TestPrintStatement() {
		
		ObjectSaving.SetBalance(80000);
		ObjectSaving.SetName("Adeeba Khan");
		ObjectSaving.SetAccountNo();
		
		ObjectSaving2.SetBalance(10000);
		ObjectSaving2.SetName("Muneeba Khan");
		ObjectSaving2.SetAccountNo();
		
		ObjectSaving.MakeDeposit(ObjectSaving, 15000);
		ObjectSaving2.MakeDeposit(ObjectSaving2, 5000);
		
		ObjectSaving.PrintStatement(ObjectSaving);
		ObjectSaving2.PrintStatement(ObjectSaving2);
		
		System.out.println("\nThe Statements have been Printed !!! ");
		
	}
}
