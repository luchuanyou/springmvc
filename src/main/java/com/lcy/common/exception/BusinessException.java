package com.lcy.common.exception;

/**
 * 业务操作异常工具类
 * @author v_luchuanyou
 *
 */
public class BusinessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3284653983939803676L;

	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
		// TODO Auto-generated constructor stub
	}

}
