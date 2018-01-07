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
