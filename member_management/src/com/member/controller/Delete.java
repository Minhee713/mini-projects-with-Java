package com.member.controller;

import java.util.Scanner;

import com.member.domain.MemberInfo;

public class Delete extends MemberInfo {
	void deleteMember(){
		MenuChoice menu = new MenuChoice();
		Scanner s = new Scanner(System.in);
		String srchName;
		String pwd;
		boolean isMember = true;
		boolean isPwdTrue = true;
		int idx = 0;;

		if (enrollMember.isEmpty()) {
			System.err.println("아직 등록된 회원이 없습니다. 회원을 등록해 주세요.");
			menu.menuPrint();
		} else {
			while (true) {
				System.out.print("삭제할 회원 이름을 입력해 주세요. ");
				srchName = s.nextLine();

				if (!(isMember = this.readMember(srchName))) {
					System.out.print("일치하는 회원이 없습니다. ");
					isMember = false;
				}
				if (isMember)
					break;
			}
			
			idx = this.getIdx(srchName);
			
			System.out.print("비밀번호를 입력하세요: ");
			pwd = s.nextLine();

			isPwdTrue = this.updateMember(idx, pwd);

			if (!isPwdTrue) {
				System.err.println("비밀번호가 일치하지 않습니다. 삭제가 불가합니다.");
				menu.menuPrint();
			} else {
				enrollMember.remove(enrollMember.get(idx));
				System.out.println("삭제 되었습니다.");
			}
		}

	}
}
