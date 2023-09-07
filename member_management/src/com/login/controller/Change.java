package com.login.controller;

import java.util.Scanner;

import com.login.domain.LoginMember;

public class Change extends LoginMember {

	private String memName;

	public void inputMember(String name) {
		this.setMemName(name);
		int idx = this.getIndex(name);

		Scanner s = new Scanner(System.in);

		System.out.print("비밀번호를 입력하세요: ");
		String myPwd = s.nextLine();

		if (!checkPwd(idx, myPwd)) {
			System.err.println("비밀번호가 일치하지 않아 수정할 수 없습니다.");
		} else {

			System.out.print(memName + " 회원의 이름을 수정하세요: ");
			String inputName = s.nextLine();

			while (checkMember(inputName)) {
				System.out.println("이미 존재하는 이름입니다. 다른 이름으로 수정해 주세요.");
				System.out.print(memName + " 회원의 이름을 수정하세요: ");
				inputName = s.nextLine();
			}

			System.out.print(memName + " 회원의 연락처를 수정하세요: ");
			String inputPhone = s.nextLine();
			System.out.print(memName + " 회원의 주소를 수정하세요: ");
			String inputAddr = s.nextLine();
			System.out.print(memName + " 회원의 비밀번호를 수정하세요: ");
			String inputPwd = s.nextLine();

			amendMember(idx, inputName, inputPhone, inputAddr, inputPwd);
			System.out.println("수정이 완료되었습니다.\n");
		}

	}

	boolean checkPwd(int idx, String pwd) {
		if (registeredMember.get(idx).getPwd().equals(pwd)) {
			return true;
		} else {
			return false;
		}
	}

	boolean checkMember(String name) {
		for (int i = 0; i < registeredMember.size(); i++) {
			if (registeredMember.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	void amendMember(int idx, String name, String phone, String addr, String pwd) {

		if (!isEmpty(name)) {
			registeredMember.get(idx).setName(name);
		}

		if (!isEmpty(phone)) {
			registeredMember.get(idx).setPhone(phone);
		}
		if (!isEmpty(addr)) {
			registeredMember.get(idx).setAddr(addr);
		}
		if (!isEmpty(pwd)) {
			registeredMember.get(idx).setPwd(pwd);
		}
	}

	boolean isEmpty(String str) {
		if (str.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
}
