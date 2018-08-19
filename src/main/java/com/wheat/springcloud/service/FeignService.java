package com.wheat.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wheat.springcloud.entity.User;

@FeignClient(value = "eureka-provider")
public interface FeignService {

	@RequestMapping("/provider/user/get/{id}")
	User getUserInfo(@PathVariable("id")Integer id);

}
