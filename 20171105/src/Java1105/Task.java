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
		int num=10;//������
		int timef0 = 0;
		int timef1 = 0;
		int timef2 = 0;
		int [] arr = {6,2,1,3,9};
		int j;
		int [][] task = new int[num][3];
		for(int i=0;i<num;i++)
		{
//��ʼ������	
		taskID = i+1;
		arrivalTime = i;
		j = (int)(Math.random()*arr.length);
		serviceTime = arr[j];
		task[i][0] = taskID;
		task[i][1] = arrivalTime;
		task[i][2] = serviceTime;
//		System.out.println("task"+taskID+":"+"  arrivalTime="+arrivalTime+"  serviceTime="+serviceTime);
//		FCFS�����ȷ����㷨1������ʱ
		startingTime=timef0;
		finishingTime=startingTime+serviceTime;
		turnAroundTime=finishingTime-arrivalTime;
		weightTurnAround=(turnAroundTime/serviceTime);
		timef0+=serviceTime;
		System.out.println("FCFS�����ȷ����㷨1������ʱtime="+timef0+";  ");
//		FCFS�����ȷ����㷨2������ʱ
		if(timef1==0){
			startingTime=arrivalTime;
			finishingTime=startingTime+serviceTime;
			turnAroundTime=finishingTime-arrivalTime;
			weightTurnAround=(turnAroundTime/serviceTime);
			timef1+=serviceTime;
			System.out.println("FCFS�����ȷ����㷨2������ʱtime1="+timef1);
		}else{
			if(timef2==0){
				startingTime=arrivalTime;
				finishingTime=startingTime+serviceTime;
				turnAroundTime=finishingTime-arrivalTime;
				weightTurnAround=(turnAroundTime/serviceTime);
			    timef2+=serviceTime+arrivalTime;
			    System.out.println("FCFS�����ȷ����㷨2������ʱtime2="+timef2);
			}else{
				if(timef1<=timef2){
					if(timef1<arrivalTime){
						timef1=arrivalTime;
					}
					timef1+=serviceTime;
					System.out.println("FCFS�����ȷ����㷨2������ʱtime1="+timef1);
				}else{
					timef2+=serviceTime;
					System.out.println("FCFS�����ȷ����㷨2������ʱtime2="+timef2);
				}
			}//end(timef2!=0)
		 }//end(timef1!=0)
		}//endfor
		SJF s = new SJF();
		for(int i = 0;i<num;i++){
			  s.add(task[i][0],task[i][1],task[i][2]) ;
			  }
			  s.fun() ;
			  System.out.println("������\t����ʱ��\t����ʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��") ;
			  s.print() ;
		
		
		
	}//endNewTask

	private void SJF(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
	
}
