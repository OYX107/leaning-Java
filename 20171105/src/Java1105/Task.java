package Java1105;

public class Task {
	int taskID;
	int arrivalTime;
	int serviceTime;
	int startingTime;
	int finishingTime;
	int turnAroundTime;
	float weightTurnAround;

	public void NewTask(){
		int num=10;//任务数
		int timef0 = 0;
		int timef1 = 0;
		int timef2 = 0;
		int [] arr = {6,2,1,3,9};
		int j;
		int [][] task = new int[num][3];
		for(int i=0;i<num;i++)
		{
//初始化数据	
		taskID = i+1;
		arrivalTime = i;
		j = (int)(Math.random()*arr.length);
		serviceTime = arr[j];
		task[i][0] = taskID;
		task[i][1] = arrivalTime;
		task[i][2] = serviceTime;
//		System.out.println("task"+taskID+":"+"  arrivalTime="+arrivalTime+"  serviceTime="+serviceTime);
//		FCFS先来先服务算法1个队列时
		startingTime=timef0;
		finishingTime=startingTime+serviceTime;
		turnAroundTime=finishingTime-arrivalTime;
		weightTurnAround=(turnAroundTime/serviceTime);
		timef0+=serviceTime;
		System.out.println("FCFS先来先服务算法1个队列时time="+timef0+";  ");
//		FCFS先来先服务算法2个队列时
		if(timef1==0){
			startingTime=arrivalTime;
			finishingTime=startingTime+serviceTime;
			turnAroundTime=finishingTime-arrivalTime;
			weightTurnAround=(turnAroundTime/serviceTime);
			timef1+=serviceTime;
			System.out.println("FCFS先来先服务算法2个队列时time1="+timef1);
		}else{
			if(timef2==0){
				startingTime=arrivalTime;
				finishingTime=startingTime+serviceTime;
				turnAroundTime=finishingTime-arrivalTime;
				weightTurnAround=(turnAroundTime/serviceTime);
			    timef2+=serviceTime+arrivalTime;
			    System.out.println("FCFS先来先服务算法2个队列时time2="+timef2);
			}else{
				if(timef1<=timef2){
					if(timef1<arrivalTime){
						timef1=arrivalTime;
					}
					timef1+=serviceTime;
					System.out.println("FCFS先来先服务算法2个队列时time1="+timef1);
				}else{
					timef2+=serviceTime;
					System.out.println("FCFS先来先服务算法2个队列时time2="+timef2);
				}
			}//end(timef2!=0)
		 }//end(timef1!=0)
		}//endfor
		SJF s = new SJF();
		for(int i = 0;i<num;i++){
			  s.add(task[i][0],task[i][1],task[i][2]) ;
			  }
			  s.fun() ;
			  System.out.println("进程名\t到达时间\t服务时间\t完成时间\t周转时间\t带权周转时间") ;
			  s.print() ;
		
		
		
	}//endNewTask

	private void SJF(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
	
}
