package com.lcy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lcy.common.enums.BaseErrorEnum;
import com.lcy.common.exception.CheckParamException;
import com.lcy.common.util.StringUtil;
import com.lcy.service.MemberInfoService;
import com.lcy.service.impl.MemberInfoServiceImpl;

/**
 * 登录接口
 * 纯servlet实现
 * @author v_luchuanyou
 *
 */
@Component
public class LoginServlet extends HttpServlet{
	static final Logger logger = Logger.getLogger(MemberInfoServiceImpl.class);
	
	MemberInfoService memberInfoService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String registerName = request.getParameter("registerName");
		String password = request.getParameter("password");
		boolean loginSuccess = false;
		try {
			logger.info("入参request"+request);
			checkParam(request);
			//获取bean对象
			getBean(request);
			loginSuccess = memberInfoService.loginSuccess(registerName, password);
			logger.info("login result:"+loginSuccess);
			if(loginSuccess){
				request.getSession().setAttribute("registerName", registerName);
				//添加cookie
				addCooike(registerName, password,request,response);
			}
		} catch (CheckParamException e) {
			loginSuccess = false;
			request.setAttribute("errorCode", e.errorCode);
			request.setAttribute("errorMsg", e.getMessage());
		} catch (Exception e) {
			logger.error("系统异常",e);
			loginSuccess = false;
			request.setAttribute("errorCode", BaseErrorEnum.ERROR_RESULT.getErrorCode());
			request.setAttribute("errorMsg", BaseErrorEnum.ERROR_RESULT.getErrorMsg());
		}
		if(!loginSuccess){//登录失败
			//重新登录
			if(StringUtil.isNotEmpty(registerName)){
				request.setAttribute("registerName", registerName);
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
//			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			request.setAttribute("errorCode", BaseErrorEnum.SUCCESS_RESULT.getErrorCode());
			request.setAttribute("errorMsg", BaseErrorEnum.SUCCESS_RESULT.getErrorMsg());
			response.sendRedirect("index.jsp");
			
		}
	}
	private void checkParam(HttpServletRequest request) throws CheckParamException {
		try {
			String registerName = request.getParameter("registerName");
			String password = request.getParameter("password");
			if(StringUtil.isEmpty(registerName)){
				throw new CheckParamException(BaseErrorEnum.MISS_PARAMETER.getErrorCode(),BaseErrorEnum.MISS_PARAMETER.getErrorMsg("用户名不能为空"));
			}
			if(StringUtil.isEmpty(password)){
				throw new CheckParamException(BaseErrorEnum.MISS_PARAMETER.getErrorCode(),BaseErrorEnum.MISS_PARAMETER.getErrorMsg("密码不能为空"));
			}
		} catch (CheckParamException e) {
			logger.error("checkParam is error,参数校验异常",e);
			throw new CheckParamException(e.errorCode,e.getMessage());
		} catch (Exception e) {
			logger.error("checkParam is error,参数校验异常",e);
			throw new CheckParamException(BaseErrorEnum.ERROR_RESULT.getErrorCode(),BaseErrorEnum.ERROR_RESULT.getErrorMsg());
		}
	}
	/**
	 * 新增cookie
	 * @param registerName
	 * @param password
	 * @param request 
	 * @param response 
	 */
	private void addCooike(String registerName, String password, HttpServletRequest request, HttpServletResponse response) {
		try {
			String saveCookieTime = request.getParameter("saveCookieTime");//cookie保存时间（天）
			int saveTime = Integer.parseInt(saveCookieTime);
			Cookie cookie = new Cookie("user", registerName+"=="+password);
			cookie.setMaxAge(saveTime * 24 * 60 * 60);
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("addCooike is error",e);
		}
	}
	/**
	 * 获取bean对象
	 * @param req
	 */
	private void getBean(HttpServletRequest req) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		memberInfoService = context.getBean(MemberInfoService.class);
	}
}
