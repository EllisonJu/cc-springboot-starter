package com.cc.mapper;

import java.util.List;

import com.cc.pojo.SysUser;
import com.cc.utils.MyMapper;

public interface SysUserMapperCustom extends MyMapper<SysUser> {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}