# 实验七    JAVA网络编程
改造教材19.2和19.3的例子，创建简单的聊天程序
- 服务器也具有类似客户端的UI界面
- 服务器也能够向客户端发送信息
- 客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录

#### 主要代码
Client.java
```
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Client extends JFrame{
	private PrintWriter writer;
	Socket socket;
	private JTextField tf=new JTextField();
	Container cc;
	JTextPane textPane = new JTextPane();
	JPanel contPane = new JPanel();  
	private BufferedReader reader;
	
	public Client(){
		super("DocColorTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		cc.setLayout(new BorderLayout());
		cc.add(new JScrollPane(textPane),"Center");
		setContentPane(cc);
		setVisible(true);
		cc.add(tf, "South");
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { stub
				writer.println(tf.getText());
				insertDocument(tf.getText()+'\n',Color.blue);
				tf.setText("");
			}
		});
	}
	public void insertDocument(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
	{
		SimpleAttributeSet set = new SimpleAttributeSet();
		StyleConstants.setForeground(set, textColor);//设置文字颜色
		StyleConstants.setFontSize(set, 12);//设置字体大小
		Document doc = textPane.getStyledDocument();
		try{
			doc.insertString(doc.getLength(), text, set);//插入文字
		}catch (BadLocationException e){
			e.printStackTrace();
		}
	}

	private void getTCPMessage(){
		try{
			while(true){	//ta.append("服务器:"+reader.readLine()+'\n');	insertDocument("服务器："+reader.readLine()+'\n',Color.red);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private void connect(){
		//ta.append("尝试连接\n");
		insertDocument("尝试连接\n",Color.black);
		try{
			socket=new Socket("127.0.0.1",8898);
			writer=new PrintWriter(socket.getOutputStream(),true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//ta.append("完成连接！\n");
			insertDocument("完成连接!\n",Color.black);
			getTCPMessage();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		Client client=new Client();
		client.setSize(200,200);
		client.setVisible(true);
		client.connect();
	}
	
}
```
Tcp.java

```
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
public class Tcp extends JFrame{
	private BufferedReader reader;
	private ServerSocket server;
	JTextPane textPane = new JTextPane();
	JPanel contPane = new JPanel(); 
	private PrintWriter writer;
	private JTextField tf=new JTextField();
	Container cc;
	public Tcp(){
		super("DocColorTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		cc.setLayout(new BorderLayout());
		cc.add(new JScrollPane(textPane),"Center");
		setContentPane(cc);
		setVisible(true);
		cc.add(tf, "South");
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());
				insertDocument(tf.getText()+'\n',Color.red);
				tf.setText("");
			}
			
		});
	}
	void getserver(){
		try{
			server=new ServerSocket(8898);
			insertDocument("套接字创建成功！\n",Color.black);
			while(true){
				insertDocument("等待客户机的响应！\n",Color.black);
				socket=server.accept();
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream(),true);
				getClientMessage();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void insertDocument(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
	{
		SimpleAttributeSet set = new SimpleAttributeSet();
		StyleConstants.setForeground(set, textColor);//设置文字颜色
		StyleConstants.setFontSize(set, 12);//设置字体大小
		Document doc = textPane.getStyledDocument();
		try{
			doc.insertString(doc.getLength(), text, set);//插入文字
		}catch (BadLocationException e){
			e.printStackTrace();
		}
	}
	
	private void getClientMessage(){
		try{
			while(true){
				insertDocument("客户机:"+reader.readLine()+'\n',Color.blue);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Tcp tcp=new Tcp();
		tcp.setSize(200,200);
		tcp.setVisible(true);
		tcp.getserver();
	}
}
```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/f7ecc7ff1e56b294d7150b211862cd24/0)