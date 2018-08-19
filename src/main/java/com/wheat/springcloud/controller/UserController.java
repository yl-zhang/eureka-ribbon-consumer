package com.wheat.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wheat.springcloud.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("get/{id}")
	public User get(@PathVariable("id") Integer id) throws Exception {
		return restTemplate.getForObject("http://eureka-provider/provider/user/get/" + id, User.class);
	}
}
