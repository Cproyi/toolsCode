package com.rmi.exception;

public class testException {

	public String throwExc() throws Exception {
		String hello = null;
		hello = init();
		if(hello == null) {
			throw new Exception("�쳣�׳�");
		}
		return hello;
	}

	private String init() {
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		testException e = new testException();
		e.throwExc();
	}
	
}
