package com.login.domain;

import java.util.ArrayList;

public class LoginMember extends ExtractInfo{
	
	public static ArrayList<LoginMember> registeredMember = new ArrayList<>();


	private String num;
	private String name;
	private String phone;
	private String addr;
	private String pwd;
	
	public LoginMember() {
		
	}

	public LoginMember(String newNum, String newName, String newPhone, String newAddr, String newPwd) {
		this.num = newNum;
		this.name = newName;
		this.phone = newPhone;
		this.addr = newAddr;
		this.pwd = newPwd;
	}
	
	public int getIndex(String name) {
		LoginMember lm = new LoginMember();
		int memIdx = -1;
		for (int i = 0; i < registeredMember.size(); i++) {
			lm = registeredMember.get(i);
			if (lm.getName().equals(name)) {
				memIdx = i;
				break;
			}
		}
		return memIdx;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pass) {
		this.pwd = pass;
	}

	

}
