package com.dms.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 该测试用例是用来完成DMSServer的内部类:ClientHandler的
 * 相关逻辑
 * 当完成后，运行该程序控制台应当会每两秒输出一行，如下内容:
 * 已存入消息队列数据:guojing,12341,7,1377660105,192.168.1.34|guojing,12341,8,1377666173,192.168.1.34
 * 已存入消息队列数据:huangr,12348,7,1377537895,192.168.1.38|huangr,12348,8,1377541495,192.168.1.38
 * 已存入消息队列数据:luwsh,12356,7,1377645205,192.168.1.45|luwsh,12356,8,1377674473,192.168.1.45
 * ...
 * 
 * 完成后替换DMSServer同名内部类即可
 * 
 * 
 * @author Xiloer
 *
 */
public class Part2 {
	//消息队列
	private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<String>();
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
			/*
			 * 实现要求:
			 * 首先接收客户端发送过来的所有配对日志，
			 * 直到读取到"OVER"为止，每读取到一条配对
			 * 日志就将其添加到消息队列中以便保存到本地的
			 * 文件(serverLogFile表示的文件)中，然后
			 * 回复客户端"OK"
			 * 执行步骤:
			 * 1:通过Socket创建输出流，用来给客户端
			 *   发送响应
			 * 2:通过Socket创建输入流，读取客户端发送
			 *   过来的日志
			 * 3:循环读取客户端发送过来的每一行字符串，并
			 *   先判断是否为字符串"OVER",若不是，则是
			 *   一条配对日志，那么将该日志存入messageQueue
			 *   消息队列中，若是，则停止读取。
			 * 4:成功读取所有日志后回复客户端"OK"   
			 * 5:若在任何一个环节出现异常，回复客户端"ERROR"
			 * 6:在finally中关闭Socket   
			 */
			
		}
	}
	
	public static void main(String[] args) {
		try {
			//启动测试客户端
			startClientDemo();
			
			//启动服务端
			ServerSocket server = new ServerSocket(8088);
			Socket socket = server.accept();
			
			
			Part2 p = new Part2();
			Part2.ClientHandler handler = p.new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
			
			while(true){
				if(p.messageQueue.size()>0){
					System.out.println("已存入消息队列数据:"+p.messageQueue.poll());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void startClientDemo(){
			new Thread(){
				public void run(){
					try {
						Thread.sleep(2000);
						Socket socket = new Socket("localhost",8088);
						PrintWriter pw = new PrintWriter(
							new OutputStreamWriter(
								socket.getOutputStream(),"UTF-8"	
							),true	
						);
						List<String> list = new ArrayList<String>();
						list.add("guojing,12341,7,1377660105,192.168.1.34|guojing,12341,8,1377666173,192.168.1.34");
						list.add("huangr,12348,7,1377537895,192.168.1.38|huangr,12348,8,1377541495,192.168.1.38");
						list.add("luwsh,12356,7,1377645205,192.168.1.45|luwsh,12356,8,1377674473,192.168.1.45");
						list.add("baizt,16321,7,1376331705,192.168.1.78|baizt,16321,8,1377798173,192.168.1.78");
						list.add("lidz,12313,7,1377679344,192.168.25.17|lidz,12313,8,1377679348,192.168.25.17");
						list.add("luxiucai,21356,7,1377663394,192.168.1.62|luxiucai,21356,8,1377679343,192.168.1.62");
						list.add("tongxy,15332,7,1376446317,192.168.1.65|tongxy,15332,8,1377667317,192.168.1.65");
						list.add("luxiucai,12311,7,1377679341,192.168.25.16|luxiucai,12311,8,1377679346,192.168.25.16");
						list.add("lidz,441232,7,1375334515,192.168.1.61|lidz,441232,8,1377679349,192.168.1.61");
						list.add("moxb,23123,7,1377441617,192.168.1.69|moxb,23123,8,1377679349,192.168.1.69");
						list.add("luwsh,12321,7,1377679353,192.168.25.12|luwsh,12321,8,1377679356,192.168.25.12");
						list.add("luwsh,12348,7,1377679366,192.168.25.12|luwsh,12348,8,1377679369,192.168.25.12");
						list.add("baizt,12323,7,1377679358,192.168.25.14|baizt,12323,8,1377679365,192.168.25.14");
						list.add("luwsh,12330,7,1377679358,192.168.25.12|luwsh,12330,8,1377679365,192.168.25.12");
						list.add("xingbt,12352,7,1377679385,192.168.25.19|xingbt,12352,8,1377679389,192.168.25.19");
						list.add("baizt,12351,7,1377679367,192.168.25.14|baizt,12351,8,1377679377,192.168.25.14");
						list.add("moxb,12339,7,1377679361,192.168.25.15|moxb,12339,8,1377679370,192.168.25.15");
						list.add("lidz,12351,7,1377679377,192.168.25.17|lidz,12351,8,1377679380,192.168.25.17");
						list.add("baizt,12357,7,1377679392,192.168.25.14|baizt,12357,8,1377679395,192.168.25.14");
						list.add("guofr,12357,7,1377679390,192.168.25.18|guofr,12357,8,1377679397,192.168.25.18");
						
						for(String s : list){
							pw.println(s);
							Thread.sleep(2000);
						}
						System.out.println("客户端发送所有日志完毕!断开连接!");
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
	}
		
}
