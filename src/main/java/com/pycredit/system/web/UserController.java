package com.pycredit.system.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pycredit.common.vo.ResponseVO;
import com.pycredit.common.web.controller.BaseController;
import com.pycredit.system.model.User;

@Controller
public class UserController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseVO<Void> login(@RequestBody User user) {
		ResponseVO<Void> responseVO = new ResponseVO<Void>();
		if ("zhangchx".equals(user.getName()) && "123456".equals(user.getPassword())) {
			logger.info("��¼�ɹ�");
			responseVO.setMessage("��¼�ɹ�");
		} else {
			responseVO.setCode(0);
			responseVO.setMessage("�û������������");
		}
		return responseVO;
	}
}
