package com.thread.t001;

public class ThreadDeadLock {

	private final Object lockA = new Object();
	
	private final Object lockB = new Object();
	
	public void doA(String name) {
		synchronized (lockA) {
			System.out.println(name + " getLockA");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockB) {
				System.out.println(name + " getLockB");
			}
		}
	}
	
	public void doB(String name) {
		synchronized (lockB) {
			System.out.println(name + " getLockB");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockA) {
				System.out.println(name + " getLockA");
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDeadLock lock = new ThreadDeadLock();
		
		new Thread(()->{
			lock.doA(Thread.currentThread().getName());
		
		},"thread1").start();
		new Thread(()->{
			lock.doB(Thread.currentThread().getName());
		},"thread2").start();
	}
}
