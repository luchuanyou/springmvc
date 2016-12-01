package com.lcy.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lcy.common.util.StringUtil;
import com.lcy.service.MemberInfoService;

/**
 * 登录拦截器
 * 登录拦截：/member/*.do
 * @author v_luchuanyou
 *
 */
@Service
public class SessionFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String registerName = (String) req.getSession().getAttribute("registerName");
		System.out.println("=======uri=="+req.getRequestURI());
		if(StringUtil.isNotEmpty(registerName)){
			checkIsLoginJsp(req, request, response);
			arg2.doFilter(request, response);//
			return;
		}
		String password = null;
		Cookie[] cookies = req.getCookies();
		if(null !=cookies){
			for (Cookie cookie : cookies) {
				String userInfo = cookie.getValue();
				String[] cooks = userInfo.split("==");
				if(cooks.length == 2){
					registerName = cooks[0];
					password = cooks[1];
				}
			}
		}
		//登录验证
		if(StringUtil.isEmpty(registerName) && StringUtil.isEmpty(password)){
			//重新登录
			reLogin(req,request, response);
		}else{
			boolean loginSuccess = checkLoginSuccess(request,registerName,password);
			if(loginSuccess){
				//设置登录态
				req.getSession().setAttribute("registerName", registerName);
				checkIsLoginJsp(req,request, response);
				//放行
				arg2.doFilter(request, response);
			}else{
				//重新登录
				reLogin(req,request, response);
			}
		}
	}
	/**
	 * 判断是否是登录页面
	 * @param req
	 * @param request
	 * @param response
	 */
	private void checkIsLoginJsp(HttpServletRequest req, ServletRequest request, ServletResponse response) {
		try {
			String uri = req.getRequestURI();
			System.out.println("==uri:"+uri);
			if(uri.contains("login.jsp")){
				req.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void reLogin(ServletRequest req, ServletRequest request, ServletResponse response) {
//		resp.sendRedirect("login.jsp");//不可以重定向到页面，Filter不是一个Servlet,它不能产生一个response,它能够在一个request达Servlet之前预处理request,也可以在离开Servlet时处理response。
		try {
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 验证用户名和密码
	 * @param request
	 * @param registerName
	 * @param password
	 * @return
	 * true：登录成功
	 * false：登录失败
	 */
	private boolean checkLoginSuccess(ServletRequest request, String registerName,
			String password) {
		try {
			WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
			MemberInfoService memberInfoService = ac.getBean(MemberInfoService.class);
			return memberInfoService.loginSuccess(registerName, password);
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
