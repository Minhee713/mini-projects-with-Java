package com.login.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.login.domain.LoginMember;

public class LoginStart extends LoginMember {

	public void loginPrint() {
		Scanner s = new Scanner(System.in);
		String inputName, inputPwd;
		int wrongPwdCnt = 0;

		while (true) {
			System.out.println("**********************************************************");
			System.out.println("                      [ 회원 로그인 ]");
			System.out.println("**********************************************************");
			System.out.print("아이디를 입력하세요: ");
			inputName = s.nextLine();
			if (checkMember(inputName)) {
				System.out.print("비밀번호를 입력하세요: ");
				inputPwd = s.nextLine();
				if (checkMember(inputName, inputPwd)) {
					System.out.println("로그인 성공!\n");
					this.toMenu(inputName);
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					wrongPwdCnt++;
				}
			} else {
				System.out.println("일치하는 회원이 없습니다.");
			}

			if (wrongPwdCnt >= 3) {
				System.err.println("로그인 횟수 초과");
				break;
			}
		}
	}

	boolean checkMember(String name) {
		for (int i = 0; i < registeredMember.size(); i++) {
			LoginMember member = registeredMember.get(i);
			if (member.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	boolean checkMember(String name, String pwd) {
		for (int i = 0; i < registeredMember.size(); i++) {
			LoginMember member = registeredMember.get(i);
			if (member.getName().equals(name) && member.getPwd().equals(pwd)) {
				return true;
			}
		}
		return false;

	}

	public void toMenu(String inputName) {

		Menu menu = new Menu();
		menu.printHello(inputName);

	}
}
