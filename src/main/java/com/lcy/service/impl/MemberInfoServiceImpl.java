package com.lcy.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcy.common.enums.BaseErrorEnum;
import com.lcy.common.exception.BusinessException;
import com.lcy.dao.MemberInfoMapper;
import com.lcy.dto.MemberInfoDTO;
import com.lcy.service.MemberInfoService;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	static final Logger logger = Logger.getLogger(MemberInfoServiceImpl.class);

	@Autowired
	MemberInfoMapper memberInfoMapper;

	public boolean loginSuccess(String registerName, String password) {
		boolean loginSuccess = false;
		try {
			List<MemberInfoDTO> userDTOList = memberInfoMapper
					.loginByRegisterNameAndPassword(new MemberInfoDTO(
							registerName, password));
			logger.info("loginByRegisterNameAndPassword userDTOList:"
					+ userDTOList);
			if (null != userDTOList && userDTOList.size() == 1) {
				loginSuccess = true;
			}
		} catch (Exception e) {
			loginSuccess = false;
			logger.error("系统异常", e);
		}
		return loginSuccess;
	}

	public MemberInfoDTO getMemberInfo(String registerName)
			throws BusinessException {
		List<MemberInfoDTO> memberInfoList = memberInfoMapper
				.getMemberInfo(registerName);
		if (null != memberInfoList && memberInfoList.size() == 0) {
			throw new BusinessException(
					BaseErrorEnum.ACCOUNT_NOT_EXIST.getErrorCode(),
					BaseErrorEnum.ACCOUNT_NOT_EXIST.getErrorMsg());
		}
		if (memberInfoList.size() > 1) {
			throw new BusinessException(
					BaseErrorEnum.ACCOUNT_MORE_ONE.getErrorCode(),
					BaseErrorEnum.ACCOUNT_MORE_ONE.getErrorMsg());
		}
		return memberInfoList.get(0);
	}

	public boolean registerMember(MemberInfoDTO memberInfoDTO) {
		boolean registerSuccess = false;
		try {
			memberInfoMapper.registerMember(memberInfoDTO);
			registerSuccess = true;
		} catch (Exception e) {
			logger.error("registerMember is error,系统异常",e);
			registerSuccess = false;
		}
		return registerSuccess;
	}

	public List<Map> testQuery(Map map) {
		// TODO Auto-generated method stub
		return memberInfoMapper.testQuery(map);
	}

}
