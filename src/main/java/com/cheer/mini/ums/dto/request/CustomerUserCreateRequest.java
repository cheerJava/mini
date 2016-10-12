package com.cheer.mini.ums.dto.request;

import com.cheer.mini.base.Constants;

public class CustomerUserCreateRequest {

    private String name;

    private String nickname;

    private String account;

    private String password;

    private short gender;
    
    private String salt;

    private static final int accountTypeFk = Constants.AccountType.ACCOUNT_TYPE_CUSTOMER;
    

    private CustomerUserCreateRequest() {
   
       
    }

    private CustomerUserCreateRequest(String name, String nickname, String account, String password, short gender) {
        super();
        this.name = name;
        this.nickname = nickname;
        this.account = account;
        this.password = password;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public static int getAccounttypefk() {
        return accountTypeFk;
    }

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "CustomerUserCreateRequest [name=" + name + ", nickname=" + nickname + ", account=" + account
				+ ", password=" + password + ", gender=" + gender + ", salt=" + salt + "]";
	}
	
	
	
}
