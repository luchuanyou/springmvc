package com.lcy.common.enums;

import com.lcy.common.util.StringUtil;

public enum BaseErrorEnum {

	SUCCESS_RESULT("0000","成功"),
	ERROR_RESULT("9999","系统异常"),
	ACCOUNT_NOT_EXIST("1010","账户不存在"),
	ACCOUNT_MORE_ONE("1011","存在多个相同账户"),
	LOGIN_TIME_OUT("1012","登录超时，请重新登录"),
	MISS_PARAMETER("1001","参数缺失:%s");
	private String errorCode;
	private String errorMsg;
	
	private BaseErrorEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg(Object... msg){
		if(null == msg) return errorMsg;
		return String.format(errorMsg, msg);
	}
}
