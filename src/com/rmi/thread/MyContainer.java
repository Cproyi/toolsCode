package com.rmi.thread;

import java.util.LinkedList;
import java.util.List;


/**
 * 生产者消费者模式
 * synchronized 实现方法
 * 
 * @author huangyuan
 *
 * @param <T>
 */
public class MyContainer<T> {
	
	private List<T> pool = new LinkedList<T>();
	
	private final static int MAXSIZE = 20;
	
	public synchronized void put(T t) {
		while(pool.size() == MAXSIZE) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pool.add(t);
		System.out.println("put one,now pool size is : " + pool.size());
		this.notifyAll();
	}
	
	public synchronized T get() {
		while(!(pool.size() > 0)) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T ret = pool.get(pool.size()-1);
		pool.remove(ret);
		System.out.println("get one,now pool size is : " + pool.size());
		this.notifyAll();
		return ret;
	}

	public static void main(String[] args) {
		
		MyContainer<String> pool = new MyContainer<>();
		
		//7个生产者
		for(int i = 0;i<7;i++) {
			final int iter = i;
			new Thread(()-> {
				while(true) {
					String val = iter + "create one source";
					pool.put(val);
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		//10个消费者
		for(int i = 0;i<10;i++) {
			new Thread(()-> {
				while(true) {
					pool.get();
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
}
