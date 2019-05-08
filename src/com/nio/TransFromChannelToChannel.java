package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
/**
 * 从channel 到 channel
 * @author hy
 *
 */
public class TransFromChannelToChannel {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("src/com/java/resources/source.txt", "rw");
		
		FileChannel from = file.getChannel();
		
		/**
		 * 当to【channel】从fileInputStraam 获取时，直接从from 写入 to 报错：
		 * java.nio.channels.NonWritableChannelException
		 */
		/*File file2 = new File("src/com/java/resources/dist3.txt");
		System.out.println(file2.canWrite());
		FileInputStream in = new FileInputStream(file2);
		FileChannel to = in.getChannel();*/
		
		/**
		 * 应写入文件，应该使用 FileOutputStream
		 * FileOutputStream 只有写权限，FileInputStream只有读权限
		 * RandomAccessFile 可控制读写权限
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
