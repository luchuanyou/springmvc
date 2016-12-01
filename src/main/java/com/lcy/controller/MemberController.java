package com.lcy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lcy.common.enums.BaseErrorEnum;
import com.lcy.common.exception.BaseException;
import com.lcy.common.exception.CheckParamException;
import com.lcy.common.util.StringUtil;
import com.lcy.dto.MemberInfoDTO;
import com.lcy.service.MemberInfoService;

@Controller
@RequestMapping("/member")
public class MemberController{

	static final Logger logger = Logger.getLogger(MemberController.class);
	@Resource
	MemberInfoService memberInfoService;
	
	@RequestMapping(value="/myQuery.do")
	public ModelAndView myQuery(HttpServletRequest request,HttpServletResponse response){
		try {
			Map map = new HashMap();
			map.put("tableName", "temp");
			List<Map> resultMap = memberInfoService.testQuery(map );
			System.out.println("result:"+resultMap);
		} catch (Exception e) {
			logger.error("myQuery is error",e);
		}
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@RequestMapping("/getMemberInfo.do")
	public ModelAndView getMemberInfo(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errorCode", "9999");
		resultMap.put("errorMsg", "系统异常");
		try {
			String registerName = (String) request.getSession().getAttribute("registerName");
			logger.info("用户信息registerName:"+registerName);
			if(StringUtil.isEmpty(registerName)){
				throw new BaseException(BaseErrorEnum.LOGIN_TIME_OUT.getErrorCode(),BaseErrorEnum.LOGIN_TIME_OUT.getErrorMsg());
			}
			MemberInfoDTO memberInfoDTO = memberInfoService.getMemberInfo(registerName);
			resultMap.put("memberInfoDTO", memberInfoDTO);
			resultMap.put("errorCode", "0000");
			resultMap.put("errorMsg", "成功");
		} catch (BaseException e) {
			logger.error("BaseException is error",e);
			resultMap.put("errorCode", e.errorCode);
			resultMap.put("errorMsg", e.errorMsg);
		} catch (Exception e) {
			logger.error("系统异常",e);
			resultMap.put("errorCode", "9999");
			resultMap.put("errorMsg", "系统异常");
		}
		ModelAndView model = new ModelAndView("member/member_info");
		model.addObject("name","hello word");
		model.addAllObjects(resultMap);
		return model;
	}
	/**
	 * 退出接口
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/loginOut.do")
	public ModelAndView loginOut(HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			if(null == session){
				response.sendRedirect("/index.jsp");
				return new ModelAndView("redirect:/index.jsp");
			}
			session.removeAttribute("registerName");
			session.invalidate();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/index.jsp");
	}
	@RequestMapping(value="/registerMember.do")
	public ModelAndView registerMember(HttpServletRequest request,HttpServletResponse response,MemberInfoDTO memberInfoDTO){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errorCode", BaseErrorEnum.ERROR_RESULT.getErrorCode());
		resultMap.put("errorMsg", BaseErrorEnum.ERROR_RESULT.getErrorMsg());
		try {
			checkRegisterMemberParams(memberInfoDTO);
			
		} catch (CheckParamException e) {
			resultMap.put("errorCode", e.errorCode);
			resultMap.put("errorMsg", e.getMessage());
		} catch (Exception e) {
			logger.error("registerMember is error,系统异常",e);
			resultMap.put("errorCode", BaseErrorEnum.ERROR_RESULT.getErrorCode());
			resultMap.put("errorMsg", BaseErrorEnum.ERROR_RESULT.getErrorMsg());
		}
		return null;
	}
	/**
	 * 参数校验
	 * @param memberInfoDTO
	 * @throws CheckParamException
	 */
	private void checkRegisterMemberParams(MemberInfoDTO memberInfoDTO) throws CheckParamException {
		try {
			if(StringUtil.isEmpty(memberInfoDTO.getRegisterName())){
				throw new CheckParamException(BaseErrorEnum.MISS_PARAMETER.getErrorCode(), BaseErrorEnum.MISS_PARAMETER.getErrorMsg("用户名不能为空"));
			}
			if(StringUtil.isEmpty(memberInfoDTO.getPassword())){
				throw new CheckParamException(BaseErrorEnum.MISS_PARAMETER.getErrorCode(), BaseErrorEnum.MISS_PARAMETER.getErrorMsg("密码不能为空"));
			}
		} catch (CheckParamException e) {
			logger.error("checkRegisterMemberParams is error",e);
			throw new CheckParamException(e.errorCode,e.getMessage());
		} catch (Exception e) {
			logger.error("checkRegisterMemberParams is error",e);
			throw new CheckParamException(BaseErrorEnum.ERROR_RESULT.getErrorCode(),BaseErrorEnum.ERROR_RESULT.getErrorMsg());
		}
	}
}
