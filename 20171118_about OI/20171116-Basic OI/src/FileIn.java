import java.io.IOException;  
import java.io.FileOutputStream;   
public class FileIn {
	public void FileIn(String name) throws IOException {      //throws �������쳣,throw ���쳣�������
        try {  
            System.out.println("please Input from Keyboard:");  
            int count, n = 512;  
            byte buffer[] = new byte[n];  
            count = System.in.read(buffer);  
            FileOutputStream wf = new FileOutputStream(name);  
            wf.write(buffer, 0, count);  
            wf.close(); // ����д��������ʱ������close�����ر�����  
            System.out.println("Save to the " + name);  
        } catch (IOException IOe) {  
            System.out.println("File Write Error!");  
        }  
    }  

}
