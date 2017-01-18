package com.pycredit.system.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pycredit.commom.vo.ResponseVO;
import com.pycredit.commom.web.controller.BaseController;
import com.pycredit.system.model.User;

@Controller
public class UserController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public UserController() {
		logger.info("==================UserController init=================");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseVO<Void> login(@RequestBody User user) {
		ResponseVO<Void> responseVO = new ResponseVO<Void>();
		if ("zhangchx".equals(user.getName()) && "123456".equals(user.getPassword())) {
			responseVO.setMessage("登录成功");
		} else {
			responseVO.setCode(0);
			responseVO.setMessage("用户名或密码错误");
		}
		return responseVO;
	}
}
