
public class SJF {
	Read r = new Read();
	int finishnum=0;
	int finish[] = new int [2];
	public void fun(Task[] task,int count){
		int temp=task[0].arrivalTime;
		int k=0;//���
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
			int y=0;//���
			for(int i=0;i<count;i++){
				if(task[i].flag==0 && task[i].arrivalTime<=finish[0]){
					//����ûִ�����Ѿ�����
					if(min>task[i].serviceTime){
						min=task[i].serviceTime;
						k=i;
						y=1;
					}
				}
			}
			if(y==0){
				finish[0]++;//û����
			}else{
				set(task[k],0);
			}

		}
		System.out.println("SJF�㷨1������");
		System.out.println("������\t����ʱ��\t����ʱ��\t��ʼʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��") ;
		for(int i=0;i<count;i++){
			   System.out.print(task[i]);
			  }
		
	}
	public void fun2(Task[] task,int count,int n){  //n=������
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
						//����ûִ�����Ѿ�����
						if(min[i]>task[j].serviceTime){
							min[i]=task[j].serviceTime;
							k[i]=j;
							y=1;
						}
					}
				}
				if(y==0){
					finish[i]++;//û����
				}else{
					set(task[k[i]],i);
				}
		}
		System.out.println("SJF�㷨"+ n +"������");
		System.out.println("������\t����ʱ��\t����ʱ��\t��ʼʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��") ;
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


