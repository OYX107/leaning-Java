 
public class Task {
	int taskID;
	int arrivalTime;
	int serviceTime;
	int startingTime;
	int finishingTime;
	int turnAroundTime;
	float weightTurnAround;
	int flag=0;//标记该进程是否已经完成
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
	public void setTurnovertime(){//计算周转时间
		this.turnAroundTime=this.finishingTime-this.arrivalTime ;
	}
	public void setWeighturnovertime(){//计算带权周转时间
		this.weightTurnAround=this.turnAroundTime/this.serviceTime ;
	}
	public String toString(){//覆写toString函数
		return this.taskID + "\t" + this.arrivalTime+ "\t" + this.serviceTime + "\t" + this.startingTime  + "\t"+ this.finishingTime + "\t" + this.turnAroundTime + "\t" + this.weightTurnAround + "\n" ;
	}
}
