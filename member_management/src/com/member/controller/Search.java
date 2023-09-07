package com.member.controller;

import java.util.Scanner;

import com.member.domain.MemberInfo;

public class Search extends MemberInfo {

	Scanner s = new Scanner(System.in);
	public String inputName;

	void searchName() {
		MenuChoice menu = new MenuChoice();
		MemberInfo member;
		boolean isMember;

		if (enrollMember.isEmpty()) {
			System.err.println("아직 등록된 회원이 없습니다. 회원을 등록해 주세요.");
			menu.menuPrint();
		} else {
			System.out.print("조회할 회원 이름을 입력해 주세요: ");
			inputName = s.nextLine();
			System.out.println(inputName + " 고객 정보 : ");

			for (int i = 0; i < enrollMember.size(); i++) {
				member = enrollMember.get(i);

				if (member.getName().equals(inputName)) {
					System.out.print("회원번호: " + member.getMemNum() + "  ");
					System.out.print("이름: " + member.getName() + "  ");
					System.out.print("연락처: " + member.getPhone() + "  ");
					System.out.println("주소: " + member.getAddr() + "\n\n");
					break;
				}

			}

			isMember = this.readMember(inputName);

			if (!isMember) {
				System.out.println("일치하는 고객정보가 없습니다.\n\n");
				menu.menuPrint();
			}

		}
	}
}
