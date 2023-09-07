package com.login.controller;

import java.util.Scanner;

import com.login.domain.LoginMember;

public class Leave extends LoginMember {

	private String memName;

	public void checkPwd(String name) {
		setMemName(name);
		Scanner s = new Scanner(System.in);
		System.out.print("비밀번호를 입력하세요: ");
		String inputPwd = s.nextLine();

		int idx = this.getIndex(memName);
		boolean myPwd = registeredMember.get(idx).getPwd().equals(inputPwd);
		if (myPwd) {
			registeredMember.remove(registeredMember.get(idx));
			System.out.println("탈퇴 되었습니다.");
			System.out.println("로그인 프로그램을 종료합니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			Menu menu = new Menu();
			menu.printHello(memName);
		}
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
}
