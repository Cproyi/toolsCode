package com.thread.t001;

import java.util.PriorityQueue;

public class Thread2 {

	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(()->{
			long end = System.currentTimeMillis();
			while((end - start)/1000<5) {
				end = System.currentTimeMillis();
			}
		});
		Thread t2 = new Thread(()->{
			long end = System.currentTimeMillis();
			while((end - start)/1000<5) {
				end = System.currentTimeMillis();
			}
		});
		Thread t3 = new Thread(()->{
			long end = System.currentTimeMillis();
			while((end - start)/1000<5) {
				end = System.currentTimeMillis();
			}
		});
		Thread t4 = new Thread(()->{
			long end = System.currentTimeMillis();
			while((end - start)/1000<5) {
				end = System.currentTimeMillis();
			}
		});
		
		t1.start();
		t1.setPriority(5);
		t2.start();
		t2.setPriority(10);
		t3.start();
		t3.setPriority(5);
		t4.start();
		t4.setPriority(10);
		long end = System.currentTimeMillis();
		while((end-start)/1000 <8) {
			System.out.println("线程t1状态" + t1.getState());
			System.out.println("线程t2状态" + t2.getState());
			System.out.println("线程t3状态" + t3.getState());
			System.out.println("线程t4状态" + t4.getState());
			end = System.currentTimeMillis();
		}
	}
}
