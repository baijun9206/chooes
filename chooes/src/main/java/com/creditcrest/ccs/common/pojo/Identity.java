package com.creditcrest.ccs.common.pojo;

import com.creditcrest.ccs.model.AuthOperation;
import com.creditcrest.ccs.model.AuthUser;

import java.util.List;

/**
 * 封装Session
 * @author CZH
 */
public class Identity {
	private String sessionId;
	private String loginIp;
	private AuthUser loginUser;
	private List<AuthOperation> operationList;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public AuthUser getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(AuthUser loginUser) {
		this.loginUser = loginUser;
	}
	public List<AuthOperation> getOperationList() {
		return operationList;
	}
	public void setOperationList(List<AuthOperation> operationList) {
		this.operationList = operationList;
	}
	
}
