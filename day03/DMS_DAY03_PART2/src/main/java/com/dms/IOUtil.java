package com.dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.bo.LogData;

/**
 * 该类是一个工具类，负责客户端的IO操作
 * @author Administrator
 *
 */
public class IOUtil {
	/**
	 * 从给定的文件中读取每一行字符串(配对日志)
	 * 并存入一个集合后返回
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static List<String> loadLogRec(File file) throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			List<String> list 
				= new ArrayList<String>();
			String line = null;
			while((line = br.readLine())!=null){
				list.add(line);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
	/**
	 * 从给定的文件中读取每一条配对日志，并存入
	 * 一个集合中然后返回。
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static List<LogData> loadLogData(File file) throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			List<LogData> list = new ArrayList<LogData>();
			String line = null;
			while((line = br.readLine())!=null){
				LogData logData = new LogData(line);
				list.add(logData);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br!=null){
				br.close();
			}
		}
	}
	
	/**
	 * 将指定的long值以字符串的形式写入到
	 * 给定文件的第一行
	 * @param l
	 * @param file
	 * @throws Exception 
	 */
	public static void saveLong(
					long lon,File file) throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(lon);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 将集合中每个元素的toString方法返回的字符串
	 * 以行为单位写入到指定文件中。
	 * @param c
	 * @param file
	 * @throws Exception 
	 */
	public static void saveCollection(
								Collection c,File file) throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for(Object o : c){
				pw.println(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 从给定的RandomAccessFile当前位置开始连续
	 * 读取length个字节，并转换为字符串后返回
	 * @param raf
	 * @param length
	 * @return
	 * @throws Exception 
	 */
	public static String readString(
					RandomAccessFile raf,int length) throws Exception{
		try {
			byte[] data = new byte[length];
			raf.read(data);
			return new String(data,"ISO8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 从给定文件中读取第一行字符串，然后将其
	 * 转换为一个long值后返回
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static long readLong(File file) throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			String line = br.readLine();
			return Long.parseLong(line);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
}







