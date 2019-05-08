package com.rmi.nulltest;

import java.util.Date;

public class TestNull {

	public static void main(String[] args) {
		Date heh = null;
		if(heh == null || heh.compareTo(new Date())>0) {
			System.out.println("cwcw");
		}
	}
	
}
