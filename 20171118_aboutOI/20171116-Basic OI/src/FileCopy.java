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
