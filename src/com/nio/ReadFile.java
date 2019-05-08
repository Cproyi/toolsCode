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
		
		//FileInputStream �Լ� RandomAccessFile ʵ�������Ի�ȡ��FileChannel
		/*File f = new File("src/com/java/resources/source.txt");
		FileInputStream file = new FileInputStream(f);*/
		
		RandomAccessFile distFile = new RandomAccessFile("src/com/java/resources/dist.txt", "rw");
		
		FileChannel distFileChannel = distFile.getChannel();
		
		/**
		 * ��Ч����д���ļ�
		 */
		/*RandomAccessFile distFile2 = new RandomAccessFile("src/com/java/resources/dist2.txt", "rw");
		
		FileChannel distFileChannel2 = distFile2.getChannel();*/
		
		/**
		 * ͨ��FileInputStream ��ȡ����fileChannel�޷���ȡ������д���ļ��У��ᱨ
		 * java.nio.channels.NonWritableChannelException �쳣
		 */
		/*File f = new File("src/com/java/resources/dist2.txt");
		FileInputStream file2 = new FileInputStream(f);
		FileChannel distFileChannel2 = file2.getChannel();*/
		
		/**
		 * Ӧд���ļ���Ӧ��ʹ�� FileOutputStream
		 * FileOutputStream ֻ��дȨ�ޣ�FileInputStreamֻ�ж�Ȩ��
		 * RandomAccessFile �ɿ��ƶ�дȨ��
		 */
		File f = new File("src/com/java/resources/dist2.txt");
		FileOutputStream file2 = new FileOutputStream(f);
		FileChannel distFileChannel2 = file2.getChannel();
		
		FileChannel fileChannel = file.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		int readByte = fileChannel.read(buffer);
		while(readByte != -1) {
			System.out.println("��ȡ��" + readByte);
			
			buffer.flip();
			while(buffer.hasRemaining()) {
				distFileChannel.write(buffer);
			
				//����buffer
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
