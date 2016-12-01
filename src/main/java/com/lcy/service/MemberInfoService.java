package com.lcy.service;

import java.util.List;
import java.util.Map;

import com.lcy.common.exception.BaseException;
import com.lcy.common.exception.BusinessException;
import com.lcy.dto.MemberInfoDTO;

public interface MemberInfoService {
	/**
	 * 用户登录
	 * @param registerName 用户名
	 * @param password 密码
	 * @return
	 * true：登录成功
	 * false：登录失败
	 */
	boolean loginSuccess(String registerName,String password);
	/**
	 * 获取用户信息
	 * @param registerName
	 * @return
	 * @throws BaseException 
	 */
	MemberInfoDTO getMemberInfo(String registerName) throws BusinessException;
	/**
	 * 注册账户
	 * @param memberInfoDTO
	 * @return
	 */
	boolean registerMember(MemberInfoDTO memberInfoDTO);
	
	List<Map> testQuery(Map map);
	
}
