package com.dms.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.dms.bo.LogData;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static List<LogData> loadLogData(File file) throws Exception
 */
public class Part1 {
	/**
	 * 从给定的文件中读取每一条配对日志,并以若干LogData实例保存然后存入
	 * 一个集合中后返回。
	 * 注:LogData有一个构造方法，可以将log.txt文件中:
	 *    lidz,441232,7,1375334515,192.168.1.61
	 *    格式的字符串直接传入，然后就生成了LogData对象。
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static List<LogData> loadLogData(File file) throws Exception{
		return new ArrayList<LogData>();
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/test/resources/log.txt");
			List<LogData> list = loadLogData(file);
			/*
			 * 测试输出结果：
			 * 应与当前目录中log.txt文件内容一致:
			 * lidz,441232,7,1375334515,192.168.1.61
			 * ....
			 */
			for(LogData log : list){
				System.out.println(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
