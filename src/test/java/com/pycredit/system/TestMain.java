package com.pycredit.system;

import org.apache.log4j.NDC;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pycredit.system.model.User;

public class TestMain {
	Logger logger = LoggerFactory.getLogger(TestMain.class);

	@Test
	public void test() {
		NDC.push("127.0.0.1");
		User user = new User();
		user.setName("уехЩ");
		user.setPassword("12345678");
		System.out.println(user.toString());
		logger.info(user.toString());
		NDC.pop();
	}

}
