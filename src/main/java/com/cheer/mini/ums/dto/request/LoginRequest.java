package com.cheer.mini.ums.dto.request;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7476450212803988549L;

	private String account;

    private String password;
    
    private Boolean rememberMe = Boolean.FALSE;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginRequest [account=" + account + ", password=" + password + ", rememberMe=" + rememberMe + "]";
	}
	
	
	
}
