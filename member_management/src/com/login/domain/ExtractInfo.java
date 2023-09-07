package com.login.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.login.controller.ManageLogin;

public class ExtractInfo implements ManageLogin {

	public void readFileMember() {
		File loadFile = new File("memberList.txt");
		String[] getParts;
		String memNum, name, phone, addr, password;

		try {
			if (!loadFile.exists()) {
				System.out.println("파일이 존재 하지 않습니다.");
			} else {
				FileReader fis = new FileReader(loadFile);
				BufferedReader br = new BufferedReader(fis);

				String str;
				while ((str = br.readLine()) != null) {
					getParts = str.split("\\s+");

					memNum = getParts[1].trim();
					name = getParts[3].trim();
					phone = getParts[5].trim();
					addr = getParts[7].trim(); 
					password = getParts[9].trim();
					
					LoginMember lm = new LoginMember(memNum, name, phone, addr, password);
					lm.registeredMember.add(lm);

				}

				fis.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void readMember() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeFileMember() {
		// TODO Auto-generated method stub

	}

}
