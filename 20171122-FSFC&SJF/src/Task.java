 
public class Task {
	int taskID;
	int arrivalTime;
	int serviceTime;
	int startingTime;
	int finishingTime;
	int turnAroundTime;
	float weightTurnAround;
	int flag=0;//��Ǹý����Ƿ��Ѿ����
	Task(int taskID,int arrivalTime,int serviceTime){
		this.taskID=taskID;
		this.arrivalTime=arrivalTime;
		this.serviceTime=serviceTime;
	}
	public void setFlag(){
		this.flag=1 ;
	}
	public void setFinishtime(int finish){
		this.finishingTime=finish ;  
	}
	public void setTurnovertime(){//������תʱ��
		this.turnAroundTime=this.finishingTime-this.arrivalTime ;
	}
	public void setWeighturnovertime(){//�����Ȩ��תʱ��
		this.weightTurnAround=this.turnAroundTime/this.serviceTime ;
	}
	public String toString(){//��дtoString����
		return this.taskID + "\t" + this.arrivalTime+ "\t" + this.serviceTime + "\t" + this.startingTime  + "\t"+ this.finishingTime + "\t" + this.turnAroundTime + "\t" + this.weightTurnAround + "\n" ;
	}
}
