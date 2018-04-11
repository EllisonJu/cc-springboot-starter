package com.cc.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.pojo.CcJSONResult;
import com.cc.pojo.SysUser;
import com.cc.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public CcJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("Miki" + new Date());
		user.setNickname("Miki" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
//		user.setAddress("青青草原");
//		user.setAge(18);
//		user.setAuthSalt("5600");
//		user.setProvince("地球");
//		user.setCity("中国");
//		user.setDistrict("山川");
//		user.setFaceImage("");
//		user.setJob("创业者");
//		user.setLastLoginIp("192.168.1.1");
//		user.setLastLoginTime(new Date());
//		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return CcJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public CcJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return CcJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public CcJSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return CcJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public CcJSONResult queryUserById(String userId) {
		
		return CcJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public CcJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return CcJSONResult.ok(userList);
	}
	
//	@RequestMapping("/queryUserListPaged")
//	public CcJSONResult queryUserListPaged(Integer page) {
//		
//		if (page == null) {
//			page = 1;
//		}
//
//		int pageSize = 10;
//		
//		SysUser user = new SysUser();
////		user.setNickname("lee");
//		
//		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
//		
//		return CcJSONResult.ok(userList);
//	}
//	
//	@RequestMapping("/queryUserByIdCustom")
//	public CcJSONResult queryUserByIdCustom(String userId) {
//		
//		return CcJSONResult.ok(userService.queryUserByIdCustom(userId));
//	}
//	
//	@RequestMapping("/saveUserTransactional")
//	public CcJSONResult saveUserTransactional() {
//		
//		String userId = sid.nextShort();
//		
//		SysUser user = new SysUser();
//		user.setId(userId);
//		user.setUsername("lee" + new Date());
//		user.setNickname("lee" + new Date());
//		user.setPassword("abc123");
//		user.setIsDelete(0);
//		user.setRegistTime(new Date());
//		
//		userService.saveUserTransactional(user);
//		
//		return CcJSONResult.ok("保存成功");
//	}
}
