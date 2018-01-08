# 实验六    熟悉Java多线程
利用4个线程分段求和1~100
- 线程1计算1~25之和；线程2计算26~50之和；以此类推
- 要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
- 打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果
#### 主要代码

```

public class  MultSum implements Runnable{
	private static Thread[]sums=new Thread[4];
	static int sum=0;
	static int num=0;
	private int threadID;
	MultSum(int id)
	{
		this.threadID=id;
	}
	public synchronized void doit(){
		if(num<=100){
			try{
				
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
			num++;
		}
	}
	public void run() {
		int s=0;
		for(int i=0;i<25;i++){
			doit();
			sum+=num;
			s+=num;
		}
		System.out.println("第"+threadID+"段:"+s);
	}
	public static void main(String [] args){
		try{
			for(int i=0;i<sums.length;i++){
				sums[i]=new Thread(new MultSum(i+1));
				sums[i].start();
				sums[i].join();
			}
		}catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("总和"+MultSum.sum);
	}
}
```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/a28d49dd6243fdb8dd7a8f16269a74f4/0)