package com.cc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.cc.pojo.CcJSONResult;
import com.cc.pojo.SysUser;
import com.cc.utils.JsonUtils;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
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
}