# 实验五 JAVA的IO操作
### 一、基本IO操作
1. 从键盘接收字节流
1. 写入到当前目录下的src.txt文件中
1. 将src.txt文件内容复制到当前目录下dest.txt文件中
1. 将dest.txt文件内容显示到屏幕上
#### 主要代码
mian.java

```
import java.io.IOException;  
import java.io.FileInputStream;  
 
public class main {  
    public static void main(String args[]) throws IOException {
    	
    	FileTest filetest = new FileTest();
    	filetest.FileTest("src.txt");
    	filetest.FileTest("dest.txt");
    	
    	FileIn fileIn = new FileIn();
    	fileIn.FileIn("src.txt");
    	
    	FileCopy fc = new FileCopy();
    	fc.FileCopy("src.txt", "dest.txt");
    	
        try{      
               FileInputStream rf=new   FileInputStream("dest.txt");  
               int n=512;   
               byte  buffer[]=new  byte[n];    
               System.out.println("输出文件内容：");
               while((rf.read(buffer,0,n)!=-1)&&(n>0)){  
                   System.out.println(new String(buffer) );  
                }  
                System.out.println();  
                rf.close();  
        } catch(IOException  IOe){        
              System.out.println(IOe.toString());  
        }  
    }  
  
}
```
FileTest.java

```
import java.io.File;
public class FileTest {
	public void FileTest(String name){
		File file = new File(name);
		if(file.exists()){
			file.delete();
			System.out.println("文件已删除");
		}else{
			try{                          //try语句捕捉可能出现的异常
				file.createNewFile();
				System.out.println("文件已创建");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
```
FileIn.java

```
import java.io.IOException;  
import java.io.FileOutputStream;   
public class FileIn {
	public void FileIn(String name) throws IOException {      //throws 可能有异常,throw 有异常立马出来
        try {  
            System.out.println("please Input from Keyboard:");  
            int count, n = 512;  
            byte buffer[] = new byte[n];  
            count = System.in.read(buffer);  
            FileOutputStream wf = new FileOutputStream(name);  
            wf.write(buffer, 0, count);  
            wf.close(); // 当流写操作结束时，调用close方法关闭流。  
            System.out.println("Save to the " + name);  
        } catch (IOException IOe) {  
            System.out.println("File Write Error!");  
        }  
    }  

}
```
FileCope.java

```
import java.io.File;  
import java.io.IOException;  
import java.io.FileOutputStream;  
import java.io.FileInputStream;  
  
public class FileCopy {  
    public void FileCopy(String name1,String name2) throws IOException {  
        try {  
            File inFile = new File(name1);  
            File outFile = new File(name2);  
            FileInputStream finS = new FileInputStream(inFile);  
            FileOutputStream foutS = new FileOutputStream(outFile);  
            int c;  
            while ((c = finS.read()) != -1) {  
                foutS.write(c);  
            }  
            finS.close();  
            foutS.close();  
        } catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);  
        }  
    }    
}

```
#### 实验结果
![image](https://qqadapt.qpic.cn/txdocpic/0/0cb94242318fa3c33950d56206f39645/0)

## 二、获取系统的文件树

- 获取某个目录下的目录信息，目录从控制台输入。
- 目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
- 目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
- 扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。

#### 主要代码
main.java

```
import java.io.*;
public class main {
	public static void main(String [] args){
		print f=new print();
		f.test();
	}
}
```


print.java
```
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class print {
	public void test() {
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter filepath");
		String str=scan.nextLine();
        String fileName=str;
        File file = new File(fileName);
        print(file);
        scan.close();
	}

	public void print(File f) {
        if (f != null) 
        {
            	List ts=new ArrayList();
            	File t;
                File [] arr = f.listFiles();
                File out=new File("filename.txt");
                DateFormat df = new SimpleDateFormat("   yyyy-MM-dd HH:mm:ss"); 
                
                if (arr != null)
                {
                	for(int i=0;i<arr.length;i++)
                	{
                			ts.add(arr[i]);
                	}
                	try{
                		PrintWriter fout=new PrintWriter(out);
                		Iterator it1=ts.iterator();
                    	Iterator it2=ts.iterator();
	                	String b;
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it1.next();
	                    	if (t.isDirectory()) 
	                        {
		                    	System.out.println(b=(t.getName()+"\t修改时间："+df.format( new Date(t.lastModified()))));
		                    	fout.write(b+"\r\n");
	                        }
	                    }
	                	for(int i=0;i<arr.length;i++)
	                	{
	                		t=(File)it2.next();
	                    	if (!t.isDirectory()) 
	                        {
	                            System.out.println(b=(t.getName()+"\t大小:"+t.length()+"字节"+"\t修改时间："+df.format( new Date(t.lastModified()))));
	                            fout.write(b+"\r\n");
	                        }
	                    }
	                	fout.close();
                	}catch (IOException e){
                		System.out.println(e.toString());
                	}
                }
        }
	}
}

```
#### 实验结果
![image](https://qqadapt.qpic.cn/txdocpic/0/e64b0c50f50bdd7f42363e2fdb06d2bf/0)