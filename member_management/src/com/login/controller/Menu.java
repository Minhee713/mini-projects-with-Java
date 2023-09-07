package com.login.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.login.domain.LoginMember;

public class Menu extends LoginMember {

	private String memName;

	public Menu() {

	}

	public void printHello(String myName) {
		Scanner s = new Scanner(System.in);
		int menuNum;
		this.setMemName(myName);
		int idx = getIndex(myName);

		System.out.println("**********************************************************");
		System.out.println("                     " + myName + "님 안녕하세요?");
		System.out.println("**********************************************************");
		System.out.println("      1. 회원 정보 확인하기 \t 2. 회원 정보 수정하기");		
		System.out.println("      3. 회원 탈퇴 \t 4. 종료");		
		System.out.println("**********************************************************");

		try {
			System.out.print("메뉴 번호를 선택해주세요:  ");
			menuNum = s.nextInt();
			this.menuChoice(menuNum, idx);
		} catch (InputMismatchException e) {
			System.err.println("입력한 값이 정수가 아닙니다. 1 ~ 4까지의 숫자를 입력해 주세요.");
			this.printHello(memName);
		}

	}

	public void menuChoice(int num, int idx) {
		LoadFile lf = new LoadFile();
		switch (num) {
		case 1:
			CheckInfo ci = new CheckInfo();
			ci.printMyinfo(registeredMember.get(idx).getName());
			this.printHello(registeredMember.get(idx).getName());
			break;
		case 2:
			Change chng = new Change();
			chng.inputMember(registeredMember.get(idx).getName());
			lf.printMemberToFile();
			this.printHello(registeredMember.get(idx).getName());
			break;

		case 3:
			Leave leave = new Leave();
			leave.checkPwd(registeredMember.get(idx).getName());
			lf.printMemberToFile();
			break;
		case 4:
			this.exitMsg();
			lf.printMemberToFile();
			break;
		default:
			this.errMsg();
			this.printHello(registeredMember.get(idx).getName());
			break;
		}

	}

	void exitMsg() {
		System.out.println("프로그램을 종료합니다.");
	}

	void errMsg() {
		System.err.println("1 ~ 4사이의 숫자를 입력해 주세요.");
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
}
