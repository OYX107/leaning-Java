import java.io.File;
public class FileTest {
	public void FileTest(String name){
		File file = new File(name);
		if(file.exists()){
			file.delete();
			System.out.println("�ļ���ɾ��");
		}else{
			try{                          //try��䲶׽���ܳ��ֵ��쳣
				file.createNewFile();
				System.out.println("�ļ��Ѵ���");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}

