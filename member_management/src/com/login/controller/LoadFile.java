package com.login.controller;

import java.io.File;
import java.io.FileWriter;

import com.login.domain.LoginMember;


public class LoadFile extends LoginMember{
	void printMemberToFile() {
		File file = new File("memberList.txt");
		try {

			if (!file.exists())
				file.createNewFile();

			FileWriter myWriter = new FileWriter(file);

			for (int i = 0; i < registeredMember.size(); i++) {
				LoginMember member = registeredMember.get(i);
				myWriter.write("회원번호: " + member.getNum() + "    ");
				myWriter.write("이름: " + member.getName() + "    ");
				myWriter.write("연락처: " + member.getPhone() + "    ");
				myWriter.write("주소: " + member.getAddr() + "    ");
				myWriter.write("비밀번호: " + member.getPwd() + "\n");
			}


			myWriter.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
