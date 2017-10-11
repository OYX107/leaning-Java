
public class Text {
	public int pub = 1;
	private int pri = 2;
	protected int pro = 3;
	//default int def = 4;
	public void publ(){}
	private void priv(){}
	protected void prot(){}
	//default int defa(){}
	public static void main(String []args){
		Text text=new Text();
		System.out.print(text.pub);
		System.out.print(text.pri);
		System.out.print(text.pro);
	//	System.out.print(text.def);
		text.publ();
		text.priv();
		text.prot();
	//	text.defa();
	}

}


