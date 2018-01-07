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