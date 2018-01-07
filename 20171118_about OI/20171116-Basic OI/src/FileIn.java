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
