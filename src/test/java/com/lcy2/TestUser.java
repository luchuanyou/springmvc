package com.lcy2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lcy.common.enums.BaseErrorEnum;
import com.lcy.service.MemberInfoService;

public class TestUser {


	@Test
	public void loginTest(){
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MemberInfoService dto = ac.getBean(MemberInfoService.class);
//		System.out.println("dto:"+dto);
//		boolean result = dto.loginSuccess("tom", "123");
//		System.out.println("登录结果:"+result);
	}
	
	@Test
	public void enumTest(){
		System.out.println("===code:"+BaseErrorEnum.ACCOUNT_NOT_EXIST.getErrorCode());
		System.out.println("===msg:"+BaseErrorEnum.ACCOUNT_NOT_EXIST.getErrorMsg());
	}
}
