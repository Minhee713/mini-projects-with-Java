package com.member.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.member.domain.MemberInfo;

public class MenuChoice extends MemberInfo {

	public void menuPrint() {
		Scanner s = new Scanner(System.in);
		System.out.println("**********************************************************");
		System.out.println("\t\t        회원 관리 프로그램");
		System.out.println("**********************************************************");
		System.out.println("      1. 고객 정보 등록하기 \t\t2. 고객 정보 조회하기");
		System.out.println("      3. 고객 정보 수정하기 \t\t4. 고객 정보 삭제하기");
		System.out.println("      5. 고객 정보 목록보기 \t\t6. 고객 정보 파일출력");
		System.out.println("      7. 종료");
		System.out.println("**********************************************************");

		int menuNum = 0;

		try {
			System.out.print("메뉴 번호를 선택해 주세요: ");
			menuNum = s.nextInt();
			menuSelect(menuNum);
		} catch (InputMismatchException e) {
			System.err.println("입력한 값이 정수가 아닙니다. 1 ~ 7까지의 숫자를 입력해 주세요.");
			this.menuPrint();
		}

	}

	public void menuSelect(int num) {

		switch (num) {
		case 1:
			Enroll erol = new Enroll();
			erol.inputInfo();
			this.menuPrint();
			break;
		case 2:
			Search srch = new Search();
			srch.searchName();
			this.menuPrint();
			break;
		case 3:
			Change chng = new Change();
			chng.reInput();
			this.menuPrint();
			break;
		case 4:
			Delete del = new Delete();
			del.deleteMember();
			this.menuPrint();
			break;
		case 5:
			ListLook look = new ListLook();
			look.listLook();
			this.menuPrint();
			break;
		case 6:
			FilePrint fp = new FilePrint();
			fp.printToFile();
			this.menuPrint();
			break;
		case 7:
			this.exitMsg();
			break;
		default:
			this.errMsg();
			this.menuPrint();
			break;
		}

	}

	public void errMsg() {
		System.err.println("입력값이 잘못되었습니다. 1~7까지의 숫저룰 입력해 주세요.");
	}

	public void exitMsg() {
		System.out.println("회원 관리 프로그램을 종료합니다.");
	}

}
