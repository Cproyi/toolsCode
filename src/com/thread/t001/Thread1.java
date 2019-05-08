package com.thread.t001;

public class Thread1 {

	public static void main(String[] args) {
		Thread t = new Thread(()-> {
			System.out.println(Thread.currentThread().getState());
			System.out.println("start..");
			try {
				long beforeWait = System.currentTimeMillis();
				Thread.sleep(3000);
				long afterWait = System.currentTimeMillis();
				System.out.println("t total sleep time " + (afterWait - beforeWait)/1000);
				System.out.println(Thread.currentThread().getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("running...");
		});
		
		t.start();
		
		Thread t1 = new Thread(()-> {
			try {
				Thread.sleep(1000);
				System.out.println(t.getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("running...");
		});
		t1.start();
	}
	
}
