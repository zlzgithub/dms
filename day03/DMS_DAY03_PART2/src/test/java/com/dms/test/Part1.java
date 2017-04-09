package com.dms.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该测试用例用来完成DMSServer的start方法功能
 * 
 * 
 * 运行后，控制台应当输出：
 * SaveLogHandler已启动!
 * 
 * 然后每两秒控制台都应当输出一次:
 * ClientHandler以启动!
 * @author Xiloer
 *
 */
public class Part1 {
	//属性定义
	//用来接收客户端连接的服务端的ServerSocket
	private ServerSocket server;
	//用来管理处理客户端请求的线程的线程池
	private ExecutorService threadPool;
	
	public Part1() {
		try {
			server = new ServerSocket(8088);
			threadPool = Executors.newFixedThreadPool(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * 服务端开始工作的方法
	 * @throws Exception
	 */
	public void start() throws Exception{
		/*
		 * 实现要求:
		 *  首先单独启动一个线程，用来运行SaveLogHandler
		 *  这个任务，目的是保存所有配对日志
		 *  然后开始循环监听服务端端口，一旦一个客户端连接了，
		 *  就实例化一个ClientHander,然后将该任务交给线程池
		 *  使其分配线程来处理与该客户端的交互。
		 *  
		 */
		try {
			System.out.println("服务端开始工作...");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		try {
			new Thread(){
				public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					while(true){
						Socket socket = null;
						try {
							socket = new Socket("localhost",8088);
						} catch (Exception e) {
							System.out.println("客户端运行失败!");
						} finally{
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
			
			Part1 p = new Part1();
			p.start();		
		} catch (Exception e) {
			System.out.println("运行异常!");
		}
	}
	
	/**
	 * 该线程负责从消息队列中取出每一条配对日志，
	 * 并存入到serverLogFile文件
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler implements Runnable{
		public void run(){
			System.out.println("SaveLogHandler已启动!");
		}
	}
	
	/**
	 * 处理一个指定客户端请求
	 * @author Administrator
	 *
	 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		public void run(){
			System.out.println("ClientHandler以启动!");
		}
	}
}
