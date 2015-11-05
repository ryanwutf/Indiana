package cn.ryanwu.indiana.service;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import cn.ryanwu.indiana.Application;
import cn.ryanwu.indiana.model.Customer;

@SpringApplicationConfiguration(classes=Application.class)
public class CustomerServiceTest extends AbstractTransactionalTestNGSpringContextTests{
	
	@Autowired
	CustomerService customerService;

	@Test
	public void testSetCustomerToCache() {
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setEmail("test@sina.com.cn");
		customer.setFullName("name1");
		customer.setTelephone("13800000000");
		customerService.setCustomerToCache(customer);
	}
}
