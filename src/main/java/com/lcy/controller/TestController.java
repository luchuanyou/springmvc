package com.lcy.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lcy.common.util.InitPropertiesUtil;

@Controller
@RequestMapping("/test")
public class TestController {

	static final Logger logger = Logger.getLogger(TestController.class);
	
	/**
	 * 获取初始化properties值
	 * @param key
	 * @return
	 */
	@RequestMapping(value="getProperties")
	public ModelAndView getProperties(String key){
		ModelAndView model = new ModelAndView("member/properties");
		String val = InitPropertiesUtil.getProperty(key);
		System.out.println(key+":"+val);
		model.addObject("val",val);
		return model;
	}
}
