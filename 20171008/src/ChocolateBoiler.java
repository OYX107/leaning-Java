
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	//�����캯������Ϊprivate����ֹ���ֱ��ͨ�����캯������������ֻ�������ڲ���������
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance(){
		//�´ε���ʱ������Ϊnull����ֱ�ӷ��ض���ʵ���ˣ�
        //���ԣ�uniqueInstanceֵ�ᱻʵ����һ�Σ�
        //Singleton��Ҳֻ����ôһ������
		if(uniqueInstance == null){
			System.out.println("Creating unique instance of Chocolate Boiler");
			uniqueInstance = new ChocolateBoiler();
			}
		return uniqueInstance;
		}
	
	public void fill(){
		if(isEmpty()){
			empty = false;
			boiled = false;
			System.out.println("Fill");
		}
		else{System.out.println("NO Fill!");
		}
	}
	
	public void boil(){
		if(!isEmpty() && !isBoiled()){
			boiled = true;
			System.out.println("Boiled");
		}
		else{
			System.out.println("No Boiled!");
			}
	}
	
	public void drain(){
		if(!isEmpty() && isBoiled()){
			empty = true;
			System.out.println("Drain");
		}
		else{
			System.out.println("No Drain!");
		}
	}
	
	public boolean isEmpty(){
		return empty;
	}
	
	public boolean isBoiled(){
		return boiled;
	}
	
	public static void main(String args[]){
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.drain();
		boiler.fill();
		boiler.drain();
		boiler.boil();
		boiler.fill();
		boiler.drain();
		boiler.boil();
	}

}
