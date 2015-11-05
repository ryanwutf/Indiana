package cn.ryanwu.indiana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.ryanwu.indiana.exception.NoCustomeFoundThreadLocalException;
import cn.ryanwu.indiana.model.Customer;
import cn.ryanwu.indiana.utils.Md5Encoder;

@Service
public class CustomerService {

	@Autowired
	protected RedisTemplate<String, Customer> redisTemplate;

	public static ThreadLocal<Customer> CUSTOMER = new ThreadLocal<>();

	public static String APP_TOKEN_PREFIX = "iNdiAna-";

	public static Customer getCustomerFromLocal() {
		if (CUSTOMER.get() != null) {
			return CUSTOMER.get();
		} else {
			throw new NoCustomeFoundThreadLocalException();
		}
	}

	public static void setCustomerToLocal(Customer customer) {
		CUSTOMER.set(customer);
	}

	public void setCustomerToCache(String key, Customer customer) {
		redisTemplate.opsForValue().set(key, customer);
	}

	public void setCustomerToCache(Customer customer) {
		setCustomerToCache(
				Md5Encoder.getInstance().encode(
						APP_TOKEN_PREFIX + String.valueOf(Math.random())),
				customer);
	}

	public Customer getCustomerFormCache(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
