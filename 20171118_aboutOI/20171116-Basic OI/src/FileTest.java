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

