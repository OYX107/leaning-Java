# 实验三
## JAVA访问权限修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
#### 主要代码

```
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
		text.publ();
		text.priv();
		text.prot();
	}
}
```
#### 实验结果
![image](https://qqadapt.qpic.cn/txdocpic/0/703c55d0d2c7f37a9ecf81a802faa40e/0)

## 单例模式——使用单例模式完成下面描述的类
Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler
ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。
1. private boolean empty;
1. private boolean boiled;
ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。
1. public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false
1. public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。
1. public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
1. isEmpty和isBoiled方法来获取empty和boiled标志位的值
#### 主要代码

```
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
```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/7d1cb1f7d914d564e30eece062e1d9fa/0)