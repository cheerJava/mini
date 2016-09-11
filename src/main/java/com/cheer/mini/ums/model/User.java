package com.cheer.mini.ums.model;

import com.cheer.mini.base.model.BaseEntity;
import com.cheer.mini.base.util.StringUtil;

public class User extends BaseEntity {
	
	public interface ORDER_USER {
		int ALL = -1;
		int Worker = 100;
		int Admin = 200;
	
	}

    //private String id = StringUtil.createUUID();
	private Boolean selected = Boolean.FALSE;
	
	private String id;
	
    private String name;

    private String nickname;

    private String account;

    private String password;

    private String salt;

    private short gender;

    private int accountTypeFk=ORDER_USER.Worker;

  
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public String getCredentialsSalt() {
        return account + salt;
    }

    public int getAccountTypeFk() {
        return accountTypeFk;
    }

    public void setAccountTypeFk(int accountTypeFk) {
        this.accountTypeFk = accountTypeFk;
    }
    
    public String getInfo(){
    	return this.toString();
    }

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public String toString() {
		return "User [selected=" + selected + ", id=" + id + ", name=" + name + ", nickname=" + nickname + ", account="
				+ account + ", password=" + password + ", salt=" + salt + ", gender=" + gender + ", accountTypeFk="
				+ accountTypeFk + "]";
	}

}
