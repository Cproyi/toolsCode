package com.rmi.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者消费者模式
 * Lock/Condition 方式实现
 * 
 * @author huangyuan
 *
 * @param <T>
 */
public class MyContainer2<T> {
	
	private List<T> pool = new LinkedList<T>();
	
	private final static int MAXSIZE = 20;
	
	private Lock lock = new ReentrantLock();
	
	private Condition producer = lock.newCondition(); 
	
	private Condition customer = lock.newCondition();
	
	public void put(T t) {
		try {
			lock.lock();
			
			while(pool.size() == MAXSIZE) {
				producer.await();
			}
			
			pool.add(t);
			System.out.println("put one,now pool size is : " + pool.size());
			
			customer.signalAll();
		}catch(Exception e)  {
				
		}finally {
			lock.unlock();
		}
	}
	
	public T get() {
		
		T ret = null;
		try {
			lock.lock();
			
			while(pool.size() == 0) {
				customer.await();
			}
			ret = pool.get(pool.size()-1);
			pool.remove(ret);
			System.out.println("get one,now pool size is : " + pool.size());
			producer.signalAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
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
