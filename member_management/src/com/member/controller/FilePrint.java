package com.member.controller;

import java.io.File;
import java.io.FileWriter;

import com.member.domain.MemberInfo;

public class FilePrint extends MemberInfo {

	void printToFile() {

		File file = new File("memberList.txt");
		try {
			if (enrollMember.isEmpty()) {
				System.err.println("아직 등록된 회원이 없습니다. 회원을 등록해 주세요.");
				MenuChoice menu = new MenuChoice();
				menu.menuPrint();
			} else {

				if (!file.exists())
					file.createNewFile();

				FileWriter myWriter = new FileWriter(file);

				for (int i = 0; i < enrollMember.size(); i++) {
					MemberInfo member = enrollMember.get(i);
					myWriter.write("회원번호: " + member.getMemNum() + "    ");
					myWriter.write("이름: " + member.getName() + "    ");
					myWriter.write("연락처: " + member.getPhone() + "    ");
					myWriter.write("주소: " + member.getAddr() + "    ");
					myWriter.write("비밀번호: " + member.getPwd() + "\n");
				}
				if (file.exists()) {
					System.out.println("[ " + file.getName() + " ]" + " 파일이 생성되었습니다.\n");
				} else {
					System.out.println("존재하는 파일이 아닙니다.");
				}

				myWriter.close();

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
