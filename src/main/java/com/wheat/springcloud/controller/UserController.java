package com.wheat.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wheat.springcloud.entity.User;
import com.wheat.springcloud.service.FeignService;

@RestController
@RequestMapping("/user")
public class UserController {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private FeignService feignService;

	@RequestMapping("get/{id}")
	public User get(@PathVariable("id") Integer id) throws Exception {
//		return restTemplate.getForObject("http://eureka-provider/provider/user/get/" + id, User.class);
		return feignService.getUserInfo(id);
	}
}
