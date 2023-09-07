package com.member.domain;

import java.util.ArrayList;

import com.member.controller.ManageMember;
import com.member.controller.MenuChoice;

public class MemberInfo implements ManageMember {
	public static ArrayList<MemberInfo> enrollMember = new ArrayList<>();
	public static int totalMember = 0;
	
	public int memNum;
	private String name;
	private String phone;
	private String addr;
	private String pwd;
	boolean isMember;
	
	int adminNum;
	String adminID;
	String adminPhone;
	String adminAddress;
	String adminPassword;
	int wrongPwdCnt = 0;

	
	public void createAdmin(int admNum, String admID, String admPhone, String admAdr, String admPwd) {
		adminNum = admNum;
		adminID = admID;
		adminPhone = admPhone;
		adminAddress = admAdr;
		adminPassword = admPwd;
	}


	public MemberInfo() {

	}

	public MemberInfo(String newName, String newPhone, String newAddr, String newPassword) {
		this.memNum = totalMember + 1;
		this.name = newName;
		this.phone = newPhone;
		this.addr = newAddr;
		this.pwd = newPassword;

	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
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

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getIdx(String newName) {

		for (int i = 0; i < enrollMember.size(); i++) {
			if (enrollMember.get(i).getName().equals(newName)) {
				return i;
			}
		}

		return 0;
	}

	@Override
	public boolean readMember(String newName) {

		for (int i = 0; i < enrollMember.size(); i++) {
			if (enrollMember.get(i).getName().equals(newName)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean updateMember(int idx, String pwd) {

		if (enrollMember.get(idx).getPwd().equals(pwd)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteMember(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fileMember() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void listMember() {
		// TODO Auto-generated method stub

	}

	public void listPrint() {
		System.out.println(enrollMember.get(0));

	}

	@Override
	public boolean createMember(int num, String name, String phone, String addr, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
