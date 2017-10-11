
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	//将构造函数声明为private，防止外界直接通过构造函数来创建对象，只能在类内部创建对象
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance(){
		//下次调用时，对象不为null，就直接返回对象实例了，
        //所以，uniqueInstance值会被实例化一次，
        //Singleton类也只有这么一个对象
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
