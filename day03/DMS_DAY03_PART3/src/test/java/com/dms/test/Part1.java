package com.dms.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 该测试用例是用来完成DMSServer的内部类:
 * SaveLogHandler的相关逻辑
 * 
 * 按照要求完成后，将该内部类替换DMSServer的
 * 同名内部类即可。
 * 
 * 启动当前程序后，当前目录下会生成一个server-logs.txt文件
 * 该文件内容为:
 * guojing,12341,7,1377660105,192.168.1.34|guojing,12341,8,1377666173,192.168.1.34
 * huangr,12348,7,1377537895,192.168.1.38|huangr,12348,8,1377541495,192.168.1.38
 *
 * @author Xiloer
 *
 */
public class Part1 {
	//保存所有客户端发送过来配对日志的文件
	private File serverLogFile = new File("src/test/java/com/dms/test/server-logs.txt");
	//消息队列
	private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<String>();

	/**
	 * 该线程负责从消息队列中取出每一条配对日志，
	 * 并存入到serverLogFile文件
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler implements Runnable{
		public void run(){
			/*
			 * 实现需求:
			 * 该线程任务是用来循环从队列(当前类属性:messageQueue)中
			 * 取出每一条配对日志，然后按行写入到serverLogFile
			 * 表示的文件中
			 * 该线程要一直工作，若消息队列中暂时没有新的配对日志
			 * 可使当前线程阻塞500毫秒，在阻塞等待前，应将缓冲流
			 * 中缓冲的日志先全部写入文件。
			 * 
			 * 实现步骤:
			 * 1:创建PrintWriter,包装FileOutputStream时
			 *   要注意，应使用追加写模式。
			 * 2:死循环以下内容
			 *   2.1:判断消息队列中是否还有日志
			 *   2.2:若有日志，则取出一条然后通过PW写出。
			 *   2.3:若没有日志，则先将PW缓存的所有日志一次
			 *       行写出，然后阻塞线程500毫秒。      
			 */
	
		}
	}
	
	public static void main(String[] args) {
		try {
			Part1 p = new Part1();
			p.messageQueue.offer("guojing,12341,7,1377660105,192.168.1.34|guojing,12341,8,1377666173,192.168.1.34");
			p.messageQueue.offer("huangr,12348,7,1377537895,192.168.1.38|huangr,12348,8,1377541495,192.168.1.38");
			
			Part1.SaveLogHandler handler = p.new SaveLogHandler();
			Thread t = new Thread(handler);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







