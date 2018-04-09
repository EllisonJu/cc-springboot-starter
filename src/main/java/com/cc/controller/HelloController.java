package com.cc.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.pojo.CcJSONResult;
import com.cc.pojo.Resource;

@RestController
public class HelloController {
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/hello")
	public Object hello() {
		return "hello springboot~MiKi~";
	}
	
	@RequestMapping("/getResource")
	public CcJSONResult getResource(){
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		return CcJSONResult.ok(bean);
	}
}
