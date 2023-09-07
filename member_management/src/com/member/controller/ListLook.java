package com.member.controller;

import java.text.DecimalFormat;

import com.member.domain.MemberInfo;

public class ListLook extends MemberInfo {

	public void listLook() {

		if (enrollMember.isEmpty()) {
			System.err.println("아직 등록된 회원이 없습니다. 회원을 등록해 주세요.");
			MenuChoice menu = new MenuChoice();
			menu.menuPrint();
		} else {

			for (int i = 0; i < enrollMember.size(); i++) {
				MemberInfo member = enrollMember.get(i);
				DecimalFormat df = new DecimalFormat("000");
				String formattedOutput = String.format("회원번호: %s \t이름: %s \t연락처: %s", df.format(member.getMemNum()), member.getName(), member.getPhone());
				System.out.println(formattedOutput);

			}
		}

	}

}
