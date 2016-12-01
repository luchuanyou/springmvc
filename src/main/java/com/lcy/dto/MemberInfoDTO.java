package com.lcy.dto;

import java.io.Serializable;

/**
 * 用户实体类
 * @author v_luchuanyou
 *
 */
public class MemberInfoDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5242841124250319977L;
	private Long id;
	private String registerName;
	private String password;
	
	public MemberInfoDTO() {
		super();
	}
	public MemberInfoDTO(String registerName, String password) {
		super();
		this.registerName = registerName;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
