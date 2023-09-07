package com.member.domain;

import java.util.Scanner;

public class Login extends MemberInfo {

	private boolean isLoginOk = false;

	public void printLogin() {
		String inputID;
		String inputPwd;
		while (true) {

			System.out.println("**********************************************************");
			System.out.println("\t\t        [ 관리자 로그인 ]");
			System.out.println("**********************************************************");
			System.out.print("아이디를 입력하세요: ");
			Scanner s = new Scanner(System.in);
			inputID = s.nextLine();
			if (!inputID.equals(this.adminID)) {
				System.out.println("일치하는 아이디가 없습니다.");
			} else {
				System.out.print("비밀번호를 입력하세요: ");
				inputPwd = s.nextLine();
				if (!inputPwd.equals(adminPassword)) {
					System.err.println("비밀번호가 틀렸습니다.");
					wrongPwdCnt++;
					if (wrongPwdCnt == 3) {
						System.err.println("로그인 횟수 초과\n");
						break;
					}
				} else {
					break;
				}
			}
		}

		if (wrongPwdCnt < 3) {
			System.out.println("로그인 성공!\n");
			this.setLoginOk(true);
		}

	}

	public boolean isLoginOk() {
		return isLoginOk;
	}

	public void setLoginOk(boolean isLoginOk) {
		this.isLoginOk = isLoginOk;
	}

}
