# JAVA集合类综合小实验





## 实验一  模拟实现FCFS（先来先服务）算法
FCFS算法按照任务到达的顺序进行服务，先来先服务
每个Task对象可以描述为至少包含下列属性：
- taskID //任务ID
- arrivalTime //到达时间
- serviceTime //服务时间
- startingTime //开始时间
- finishingTime //完成时间=开始时间+服务时间
- turnAroundTime //周转时间=完成时间-达到时间
- weightTurnAround //带权周转时间=周转时间/服务时间
- 其他的属性根据程序需要设置

任务(Task)的ID、开始时间和服务时间由文件读入，形如图所示。
这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。
文件列表要包含至少100个任务。

先要求实现如下要求的FCFS
1. 当只有一个处理队列时的情况
1. 当有两个处理队列时的情况


#### 主要代码
```
public void fscsSingle(SortedSet<Task> ts){
	int lastFinTime=0;
	Task t=new Task();
	Iterator<Task> iterator=ts.iterator();
	for(int i=1;i<=100;i++)
	{
		t=iterator.next();
		if(t.getArrTime()>=lastFinTime)
			t.setStart(t.getArrTime());
		else
			t.setStart(lastFinTime);
		t.setFinish(t.getStartTime()+t.getSerTime());
		t.setTurnAround(t.getFinTime()-t.getArrTime());
		t.setWeight((double)t.getTurnAround()/t.getSerTime());
		lastFinTime=t.getFinTime();
	}
}
public void fscsDouble(SortedSet<Task> ts){
	int lastTime1=0;
	int lastTime2=0;
	Task t=new Task();
	Iterator<Task> iterator=ts.iterator();
	for(int i=1;i<=100;i++){
		t=iterator.next();
		if(t.getArrTime()>=lastTime1 && t.getArrTime()>=lastTime2)
		{
			t.setStart(t.getArrTime());
			t.setFinish(t.getStartTime()+t.getSerTime());
			t.setTurnAround(t.getFinTime()-t.getArrTime());
			t.setWeight((double)t.getTurnAround()/t.getSerTime());
			if((t.getArrTime()-lastTime1)>=(t.getArrTime()-lastTime2))
			{
				
				t.setTag(1);
				
				lastTime1=t.getFinTime();
			}
			else 
			{
				t.setTag(2);
				lastTime2=t.getFinTime();
				
			}
			
		}
		else if(t.getArrTime()>=lastTime1 || t.getArrTime()>=lastTime2)
		{
			if(t.getArrTime()>=lastTime1)
			{
				t.setStart(t.getArrTime());
				t.setTag(1);
				t.setFinish(t.getStartTime()+t.getSerTime());
				t.setTurnAround(t.getFinTime()-t.getArrTime());
				t.setWeight((double)t.getTurnAround()/t.getSerTime());
				lastTime1=t.getFinTime();
			}
			else
			{
				t.setStart(t.getArrTime());
				t.setTag(2);
				t.setFinish(t.getStartTime()+t.getSerTime());
				t.setTurnAround(t.getFinTime()-t.getArrTime());
				t.setWeight((double)t.getTurnAround()/t.getSerTime());
				lastTime2=t.getFinTime();
			}
		}
		else if(t.getArrTime()<lastTime1 && t.getArrTime()<lastTime2)
		{
			if((lastTime1-t.getArrTime())<=(lastTime2-t.getArrTime()))
			{
				t.setStart(lastTime1);
				t.setTag(1);
				t.setFinish(t.getStartTime()+t.getSerTime());
				t.setTurnAround(t.getFinTime()-t.getArrTime());
				t.setWeight((double)t.getTurnAround()/t.getSerTime());
				lastTime1=t.getFinTime();
			}
			else
			{
				t.setStart(lastTime2);
				t.setTag(2);
				t.setFinish(t.getStartTime()+t.getSerTime());
				t.setTurnAround(t.getFinTime()-t.getArrTime());
				t.setWeight((double)t.getTurnAround()/t.getSerTime());
				lastTime2=t.getFinTime();
			}
		}
		
	}
}
```
 
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/719c1f666a39e26532657f71444cdf0a/0)
![image](https://qqadapt.qpic.cn/txdocpic/0/f2439c1fbac268cf386655a8905389e1/0)

## 实验二   模拟实现SJF（短作业优先）
SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
按照FCFS算法的要求实现SJF算法，
同样要求处理两种情况：
1. 当只有一个处理队列时的情况
1. 当有两个处理队列时的情况

#### 主要代码

```

public class SJF {
	Read r = new Read();
	int finishnum=0;
	int finish[] = new int [2];
	public void fun(Task[] task,int count){
		int temp=task[0].arrivalTime;
		int k=0;//标记
		for(int i=0;i<count;i++){
			if(temp>task[i].arrivalTime){
				temp=task[i].arrivalTime;
				k=i;
			}
		}
		finish[0]=temp;
		set(task[k],0);
		
		while(finishnum!=count){
			int min=999;
			int y=0;//标记
			for(int i=0;i<count;i++){
				if(task[i].flag==0 && task[i].arrivalTime<=finish[0]){
					//任务还没执行且已经到达
					if(min>task[i].serviceTime){
						min=task[i].serviceTime;
						k=i;
						y=1;
					}
				}
			}
			if(y==0){
				finish[0]++;//没任务到
			}else{
				set(task[k],0);
			}

		}
		System.out.println("SJF算法1个队列");
		System.out.println("进程名\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间") ;
		for(int i=0;i<count;i++){
			   System.out.print(task[i]);
			  }
		
	}
	public void fun2(Task[] task,int count,int n){  //n=队列数
		int []temp = new int [n];
		int []k = new int [n];
//		int []finish = new int[n];
		for(int i=0;i<n;i++){
			temp[i]=task[i].arrivalTime;
			for(int j=0;j<count;j++){
				if(temp[i]>=task[j].arrivalTime && task[j].flag==0){
					temp[i]=task[j].arrivalTime;
					k[i]=j;
					
				}
			}
			finish[i]=temp[i];
			set(task[k[i]],finish[i]);	
			
		}
		while(finishnum!=count){
			int min[] = new int [n];
			int y=0;
			int min_i=999;
			int i = 0;
			for(int h=0;h<n;h++){
				if(min_i>finish[i]){
					min_i=finish[i];
					h=i;
				}
			}
			
				min[i]=999;
				for(int j=0;j<count;j++){
					if(task[j].flag==0 && task[j].arrivalTime<=finish[i]){
						//任务还没执行且已经到达
						if(min[i]>task[j].serviceTime){
							min[i]=task[j].serviceTime;
							k[i]=j;
							y=1;
						}
					}
				}
				if(y==0){
					finish[i]++;//没任务到
				}else{
					set(task[k[i]],i);
				}
		}
		System.out.println("SJF算法"+ n +"个队列");
		System.out.println("进程名\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间") ;
		for(int i=0;i<count;i++){
			   System.out.print(task[i]) ;
			  }
	}
	public void set(Task task,int i){
		task.startingTime=finish[i];
		finish[i]+=task.serviceTime;
		task.setFinishtime(finish[i]);
		task.setTurnovertime();
		task.setWeighturnovertime();
		task.setFlag();
		finishnum++;
	}
}



```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/bfc68a0ec622acfb10785640a854b227/0)
![image](https://qqadapt.qpic.cn/txdocpic/0/1cf03f822e1010788db170d36d8c1476/0)