package com.login.main;

import com.login.controller.LoginStart;
import com.login.domain.ExtractInfo;
import com.login.domain.LoginMember;

public class LoginMemberClient{
	public static void main(String[] args) {
		ExtractInfo exInfo = new ExtractInfo();
		exInfo.readFileMember();		

		LoginStart ls = new LoginStart();
		ls.loginPrint();
		
	}
}
