package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile file = new RandomAccessFile("src/com/java/resources/source.txt", "rw");
		
		//FileInputStream 以及 RandomAccessFile 实例均可以获取到FileChannel
		/*File f = new File("src/com/java/resources/source.txt");
		FileInputStream file = new FileInputStream(f);*/
		
		RandomAccessFile distFile = new RandomAccessFile("src/com/java/resources/dist.txt", "rw");
		
		FileChannel distFileChannel = distFile.getChannel();
		
		/**
		 * 有效，可写入文件
		 */
		/*RandomAccessFile distFile2 = new RandomAccessFile("src/com/java/resources/dist2.txt", "rw");
		
		FileChannel distFileChannel2 = distFile2.getChannel();*/
		
		/**
		 * 通过FileInputStream 获取到的fileChannel无法获取将数据写到文件中，会报
		 * java.nio.channels.NonWritableChannelException 异常
		 */
		/*File f = new File("src/com/java/resources/dist2.txt");
		FileInputStream file2 = new FileInputStream(f);
		FileChannel distFileChannel2 = file2.getChannel();*/
		
		/**
		 * 应写入文件，应该使用 FileOutputStream
		 * FileOutputStream 只有写权限，FileInputStream只有读权限
		 * RandomAccessFile 可控制读写权限
		 */
		File f = new File("src/com/java/resources/dist2.txt");
		FileOutputStream file2 = new FileOutputStream(f);
		FileChannel distFileChannel2 = file2.getChannel();
		
		FileChannel fileChannel = file.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		int readByte = fileChannel.read(buffer);
		while(readByte != -1) {
			System.out.println("读取数" + readByte);
			
			buffer.flip();
			while(buffer.hasRemaining()) {
				distFileChannel.write(buffer);
			
				//复用buffer
				System.out.println("before rewind : position: " + buffer.position() + " limit: " + buffer.limit());
				buffer.rewind();
				System.out.println("after rewind : position: " + buffer.position() + " limit: " + buffer.limit());
				distFileChannel2.write(buffer);
			}
			
			buffer.clear();
			readByte = fileChannel.read(buffer);
		}
		
		distFileChannel.close();
		distFileChannel2.close();
		fileChannel.close();
	}
	
}
