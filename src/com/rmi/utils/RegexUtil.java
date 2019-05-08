package com.rmi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	public boolean isPhoneNo(String phone){
	   boolean flag = false;
	   try{
//			   Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
//			   Pattern regex = Pattern.compile("^1[34578]\\d{9}$");
		   Pattern regex = Pattern.compile("^(1[0-9])\\d{9}$");
		   Pattern regex1 = Pattern.compile("^\\d{8}$");
		   Matcher match = regex.matcher(phone);
		   flag = match.matches();
		   if(!flag) {
			   Matcher match1 = regex1.matcher(phone);
			   flag = match1.matches();
		   }
	   }catch(Exception e){
	       flag = false;
	   }
	       return flag;
	}
	
	public static void main(String[] args) {
		RegexUtil util = new RegexUtil();
		System.out.println(util.isPhoneNo("12453678902"));
		System.out.println(util.isPhoneNo("22345678901"));
		System.out.println(util.isPhoneNo("12345678"));
		System.out.println(util.isPhoneNo("82345678"));
		System.out.println(util.isPhoneNo("82345689"));
		System.out.println(util.isPhoneNo("t2345678"));
		System.out.println(util.isPhoneNo("t234567f"));
		System.out.println(util.isPhoneNo("t234f678"));
		System.out.println(util.isPhoneNo("823456"));
		System.out.println(util.isPhoneNo("82345"));
	}
	
}
