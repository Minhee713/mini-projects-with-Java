package com.member.main;

import com.member.controller.MenuChoice;
import com.member.domain.Login;

public class MemberClient {
	public static void main(String[] args) {
		Login start = new Login();
		boolean isLoginOk;

		start.createAdmin(0, "admin", "01012345678", "서울시 서대문구", "admin");
		start.printLogin();

		isLoginOk = start.isLoginOk();

		if (isLoginOk) {
			MenuChoice c = new MenuChoice();
			c.menuPrint();
		}

	}

}
