package com.member.controller;

import java.util.Scanner;

import com.member.domain.MemberInfo;

public class Enroll extends MemberInfo {

	Scanner s = new Scanner(System.in);
	String name;
	String phone;
	String addr;
	String password;
	boolean isMember;

	public void inputInfo() {

		while (true) {

			System.out.print("등록하실 회원의 이름을 입력하세요: ");
			name = s.nextLine();
			System.out.print("등록하실 회원의 연락처을 입력하세요: ");
			phone = s.nextLine();
			System.out.print("등록하실 회원의 주소를 입력하세요: ");
			addr = s.nextLine();
			System.out.print("등록하실 회원의 비밀번호를 입력하세요: ");
			password = s.nextLine();

			isMember = this.readMember(name);

			if (isMember) {
				System.out.println("이미 존재하는 이름입니다. 다른 이름으로 등록해 주세요.");
			} else {
				break;
			}
		}

		MemberInfo newMember = new MemberInfo(name, phone, addr, password);
		enrollMember.add(newMember);

		System.out.println("등록이 완료 되었습니다.\n");
		this.totalMember++;

//		System.out.println("\ntest: enroll: totalMember " + this.totalMember);
//		System.out.println("test: enroll: memNum " + this.memNum);

	}

}
