
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
		System.out.println("µÚ"+threadID+"¶Î:"+s);
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
		System.out.println("×ÜºÍ"+MultSum.sum);
	}
}