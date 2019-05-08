package com.thread.t001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColletionSych {

	private List<String> sychroList = Collections.synchronizedList(new ArrayList<String>());
	
	public void set(String str) {
		sychroList.add(str);
	}
	
	public void get() {
		sychroList.remove(0);
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
