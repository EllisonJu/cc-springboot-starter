package com.cc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.pojo.CcJSONResult;
import com.cc.pojo.SysUser;
import com.cc.pojo.User;
import com.cc.utils.JsonUtils;
import com.cc.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public CcJSONResult test() {
		
		strRedis.opsForValue().set("cc-cache", "hello Miki~~~~~~");
		
		SysUser user = new SysUser();
		user.setId("10001");
		user.setUsername("Miki");
		user.setNickname("Miki");
		user.setPassword("111111");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
		
		SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
		
		return CcJSONResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public CcJSONResult getJsonList() {
		
		User user = new User();
		user.setAge(18);
		user.setName("jojo");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("pig");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("hello pig");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList),10000);
		
		String userListJson = redis.get("json:info:userlist");
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		return CcJSONResult.ok(userListBorn);
	}
}