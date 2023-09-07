package com.member.controller;

public interface ManageMember {
	abstract boolean createMember(int num, String name, String phone, String addr, String pwd);

	abstract boolean readMember(String name);

	abstract boolean updateMember(int idx, String pwd);

	abstract boolean deleteMember(int num);

	abstract boolean fileMember();

	abstract void listMember();

}
