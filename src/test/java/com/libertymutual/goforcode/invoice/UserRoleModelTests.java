package com.libertymutual.goforcode.invoice;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.meanbean.test.ConfigurationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.meanbean.test.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.libertymutual.goforcode.invoice.models.User;
import com.libertymutual.goforcode.invoice.models.UserRole;


public class UserRoleModelTests {

	UserRole userRole;

	@Before
	public void setUp() {
		userRole = new UserRole();
	}


	@Test
	public void test_all_getters_and_setters() {
		BeanTester tester = new BeanTester();
		Configuration configuration = new ConfigurationBuilder().build();
		tester.testBean(UserRole.class, configuration);
	}
}