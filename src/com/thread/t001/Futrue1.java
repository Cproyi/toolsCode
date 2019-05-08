package com.thread.t001;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Futrue1 {

	public static void main(String[] args) {
		
		/*new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		}) ;*/
		
		new FutureTask<Integer>(()->{
			
			return 1;
		});
		
	}
	
}
