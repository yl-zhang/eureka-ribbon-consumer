package com.wheat.springcloud.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wheat.springcloud.entity.User;


@RestController
@RequestMapping("/user")
public class UserController {
	private static final Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient client;

	@RequestMapping("get/{id}")
	public User get(@PathVariable("id") Integer id) throws Exception {
		List<ServiceInstance> list = this.client.getInstances("EUREKA_PROVIDER");
		String uri = "";
	    for (ServiceInstance instance : list) {
	        if (instance.getUri() != null && !"".equals(instance.getUri())) {
	        	uri = instance.getUri().toString();
	        	break;
	        }
	    }
	    log.info("获取到的服务uri = " + uri);
		return restTemplate.getForObject(uri + "/provider/user/get/" + id, User.class);
	}
}
