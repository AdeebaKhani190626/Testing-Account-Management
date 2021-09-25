import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BMS.CheckingAccount;
import BMS.CustomerInfo;

public class AccountsInfo {

	private CustomerInfo ObjectInfo;
	private CustomerInfo ObjectInfo2;
	private CustomerInfo ObjectInfo3;
	private CustomerInfo ObjectInfo4;
	
	@Before
	public void setUp() throws Exception {
		ObjectInfo = new CustomerInfo();
		ObjectInfo2 = new CustomerInfo("Adeeba Khan", "Westridge Road",033223, 06265, 2342, "Checking",10000,"01-03-2001");
		ObjectInfo3 = new CustomerInfo("Muneeba Khan", "Westridge Road",033223, 06265, 2342, "Saving",23044,"12-04-1997");
		ObjectInfo4 = new CustomerInfo("Umer Khan", "Westridge Road",033223, 06235, 32342, "Don't Know",23044,"29-01-2003");
	}

	@After
	public void setUpA() throws Exception {
		System.out.println(" \n *** The 'Test'  has been executed successfully !!! *** ");
	}
	
	@Test
	public void TestingDisplayingAccountInfo() {
		
		ObjectInfo2.DisplayAccountInfo(1);
		Assert.assertTrue(ObjectInfo2.GetDisplay());
		ObjectInfo3.DisplayAccountInfo(2);
		Assert.assertTrue(ObjectInfo3.GetDisplay());
	}
	
	@Test
	public void TestingDisplayingAccountDeductions() {
		
		ObjectInfo2.DisplayAllDeductions(1);
		Assert.assertTrue(ObjectInfo2.GetDeductions());
		ObjectInfo3.DisplayAllDeductions(2);
		Assert.assertTrue(ObjectInfo3.GetDeductions());
		ObjectInfo4.DisplayAllDeductions(1);
		Assert.assertFalse(ObjectInfo4.GetDeductions());
	}

}
