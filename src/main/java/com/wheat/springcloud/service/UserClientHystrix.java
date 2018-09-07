package com.wheat.springcloud.service;

import org.springframework.stereotype.Service;

import com.wheat.springcloud.entity.User;

@Service
public class UserClientHystrix implements FeignService{

	@Override
	public User getUserInfo(Integer id) {
		User user = new User();
		user.setUserName("未查找到用户");
		user.setPassword("123456");
		user.setPort(8858);
		return user;
//		throw new RuntimeException("can't get user info , server runtime exception !!!"); 
	}

}
