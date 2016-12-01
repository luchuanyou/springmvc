package com.lcy.common.exception;

/**
 * 参数验证例外工具类
 * @author v_luchuanyou
 *
 */
public class CheckParamException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4625545604983822745L;

	public CheckParamException() {
		super();
	}

	public CheckParamException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	
}
