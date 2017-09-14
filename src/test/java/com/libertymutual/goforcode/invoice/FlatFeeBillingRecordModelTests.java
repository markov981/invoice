package com.libertymutual.goforcode.invoice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.meanbean.test.BeanTester;
import org.meanbean.test.ConfigurationBuilder;
import org.meanbean.test.Configuration;

import com.libertymutual.goforcode.invoice.models.FlatFeeBillingRecord;
import com.libertymutual.goforcode.invoice.models.RateBasedBillingRecord;



public class FlatFeeBillingRecordModelTests {

	FlatFeeBillingRecord flatFeeBillingRecord;

	@Before
	public void setUp() {
		flatFeeBillingRecord = new FlatFeeBillingRecord();
	}

	
	@Test
	public void test_get_total_method_flat() {
		double delta = 1e-10; 
		double resultA = flatFeeBillingRecord.getTotal();	
		double resultB = flatFeeBillingRecord.getAmount();
		assertEquals(resultA, resultB,  delta);
	}
	
	
	@Test
	public void test_all_getters_and_setters_but_the_date_field() {
		BeanTester tester = new BeanTester();
		Configuration configuration = new ConfigurationBuilder().ignoreProperty("createdOn").build();
		tester.testBean(FlatFeeBillingRecord.class, configuration);
	}
	
	@Test
	public void test_get_set_for_a_date_field() {
        java.util.Date uDate = new java.util.Date();
        java.sql.Date  sDate = new java.sql.Date(uDate.getTime());
        flatFeeBillingRecord.setCreatedOn(sDate);		
		assertEquals(sDate, flatFeeBillingRecord.getCreatedOn());
	}
}