package com.login.controller;

import java.text.DecimalFormat;

import com.login.domain.LoginMember;

public class CheckInfo extends LoginMember {

	public void printMyinfo(String name) {
		System.out.println(name + " 고객 정보 : ");
		int idx = this.getIndex(name);
		
		String num = registeredMember.get(idx).getNum();
		DecimalFormat df = new DecimalFormat("000");
		System.out.print("회원번호 " + df.format(Integer.parseInt(num)));
		System.out.print("  이름  " + registeredMember.get(idx).getName());
		System.out.print("  연락처  " + registeredMember.get(idx).getPhone());
		System.out.println("  주소  " + registeredMember.get(idx).getAddr());

	}

}
