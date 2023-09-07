package com.member.controller;

import java.util.Scanner;

import com.member.domain.MemberInfo;

public class Change extends MemberInfo {
	void reInput(){
		MenuChoice menu = new MenuChoice();
		Scanner s = new Scanner(System.in);
		boolean isMember = true;
		boolean isPwdWrong = true;
		boolean isEnter = true;
		String srchName, reName, rePhone, reAddr, pwd;
		int idx;

		if (enrollMember.isEmpty()) {
			System.err.println("아직 등록된 회원이 없습니다. 회원을 등록해 주세요.");
			menu.menuPrint();
		} else {
			while (true) {
				System.out.print("수정할 회원 이름을 입력해 주세요. ");
				srchName = s.nextLine();

				if (!(isMember = this.readMember(srchName))) {
					System.out.print("일치하는 회원이 없습니다. ");
					isMember = false;
				}
				if (isMember)
					break;
			}

			idx = this.getIdx(srchName);

			System.out.print(srchName + " 회원의 이름을 수정하세요: ");
			reName = s.nextLine();
			System.out.print(srchName + " 회원의 연락처를 수정하세요: ");
			rePhone = s.nextLine();
			System.out.print(srchName + " 회원의 주소를 수정하세요: ");
			reAddr = s.nextLine();
			System.out.print(srchName + " 회원의 비밀번호를 입력하세요: ");
			pwd = s.nextLine();

			isPwdWrong = this.updateMember(idx, pwd);

			if (!isPwdWrong) {
				System.err.println("비밀번호가 일치하지 않습니다. 정보 수정이 불가합니다.");
				menu.menuPrint();
			} else {
				if (isEmty(reName)) {
					enrollMember.get(idx).setName(enrollMember.get(idx).getName());
				} else {
					enrollMember.get(idx).setName(reName);
				}
				if (isEmty(rePhone)) {
					enrollMember.get(idx).setPhone(enrollMember.get(idx).getPhone());
				} else {
					enrollMember.get(idx).setPhone(rePhone);
				}
				if (isEmty(reAddr)) {
					enrollMember.get(idx).setAddr(enrollMember.get(idx).getAddr());
				} else {
					enrollMember.get(idx).setAddr(reAddr);
				}
				System.out.println("수정이 완료되었습니다.\n\n");

			}

		}

	}

	boolean isEmty(String str) {
		if (str.equals(""))
			return true;
		else
			return false;
	}
}
