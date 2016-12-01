package com.lcy.dao;

import java.util.List;
import java.util.Map;

import com.lcy.dto.MemberInfoDTO;

/**
 * 用户操作接口
 * @author v_luchuanyou
 *
 */
public interface MemberInfoMapper {

	List<MemberInfoDTO> loginByRegisterNameAndPassword(MemberInfoDTO userDTO);
	//获取用户信息
	List<MemberInfoDTO> getMemberInfo(String registerName);
	/**
	 * 注册账户
	 * @param memberInfoDTO
	 * @return
	 */
	boolean registerMember(MemberInfoDTO memberInfoDTO);
	
	List<Map> testQuery(Map map);
}
