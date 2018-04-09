package com.cc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cc.pojo.CcJSONResult;
import com.cc.pojo.User;

//@Controller
@RestController   //@RestController =@Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
//	@ResponseBody
	public User hello() {
		
		User u = new User();
		u.setName("Miki");
		u.setPassword("123456");
		u.setAge(22);
		u.setBirthday(new Date());
		u.setDesc("非常帅气");
		
		return u;
	}
	
	@RequestMapping("/getUserJson")
//	@ResponseBody
	public CcJSONResult getUserJson() {
		
		User u = new User();
		u.setName("Miki");
		u.setPassword("123456");
		u.setAge(20);
		u.setBirthday(new Date());
		u.setDesc("非常帅气");
		
		return CcJSONResult.ok(u);
	}
}
