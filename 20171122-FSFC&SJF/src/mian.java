
public class mian {
	public static void main(String[] args)throws Exception{
		new Read().read("input.txt");
		Exception e = new Exception();
		System.err.println(e.getMessage());
	}
	
}
