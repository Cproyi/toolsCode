package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
/**
 * ��channel �� channel
 * @author hy
 *
 */
public class TransFromChannelToChannel {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("src/com/java/resources/source.txt", "rw");
		
		FileChannel from = file.getChannel();
		
		/**
		 * ��to��channel����fileInputStraam ��ȡʱ��ֱ�Ӵ�from д�� to ����
		 * java.nio.channels.NonWritableChannelException
		 */
		/*File file2 = new File("src/com/java/resources/dist3.txt");
		System.out.println(file2.canWrite());
		FileInputStream in = new FileInputStream(file2);
		FileChannel to = in.getChannel();*/
		
		/**
		 * Ӧд���ļ���Ӧ��ʹ�� FileOutputStream
		 * FileOutputStream ֻ��дȨ�ޣ�FileInputStreamֻ�ж�Ȩ��
		 * RandomAccessFile �ɿ��ƶ�дȨ��
		 */
		/*File file2 = new File("src/com/java/resources/dist3.txt");
		System.out.println(file2.canWrite());
		FileOutputStream in = new FileOutputStream(file2);
		FileChannel to = in.getChannel();*/
		
		RandomAccessFile file2 = new RandomAccessFile("src/com/java/resources/dist3.txt", "rw");
		
		FileChannel to = file2.getChannel();
		
		long count = from.size();
		
		from.transferTo(0, count, to);
		
		from.close();
		to.close();
	}
	
}
