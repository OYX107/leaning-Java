package Java1105;

public class SJF {
	
		 class B{//�ڲ��෽��
		  private int processname ;//s������
		  private int arrivetime ;//����ʱ��
		  private int servetime ;//����ʱ��   
		  private int finishtime ;//���ʱ��
		  private int turnovertime ;//��תʱ��
		  private float weighturnovertime ;//��Ȩ��תʱ��
		  private int flag=0 ;//��Ǹý����Ƿ��Ѿ����
		  
		  public B(int processname,int arrivetime,int servetime){//���췽��ֻ������֪��
		   this.processname=processname ;
		   this.arrivetime=arrivetime ;
		   this.servetime=servetime ;
		  }
		  public void setFlag(){
		   this.flag=1 ;
		  }
		  public void setFinishtime(int finish){
		   this.finishtime=finish ;  
		  }
		  public void setTurnovertime(){//������תʱ��
		   this.turnovertime=this.finishtime-this.arrivetime ;
		  }
		  public void setWeighturnovertime(){//�����Ȩ��תʱ��
		   this.weighturnovertime=this.turnovertime/this.servetime ;
		  }
		  public String toString(){//��дtoString����
		   return this.processname + "\t" + this.arrivetime+ "\t\t" + this.servetime + "  \t"
		    + this.finishtime + "\t\t" + this.turnovertime + "\t\t" + this.weighturnovertime + "\n" ;
		  }
		 }
		  
		 private B processes[]=new B[10] ;//��������
		 private int n=0 ;//��¼������
		 private int finishnum=0 ;//��¼�Ѿ���ɵĽ�����
		 private  int finish=0 ;
		 private float aveturnovertime ;//ƽ����תʱ��
		 private float aveweighturnovertime ;//ƽ����Ȱ��תʱ��
		 public void setFinish(float servetime){
		  finish+=servetime ;
		 }
		 public void add(int processname,int arrivetime,int servetime){//��ӽ��̲��������ʱ��
		  B process=new B(processname,arrivetime,servetime) ;
		  this.processes[n]=process ;
		  n++ ;
		 }
		 public void fun(){
		  //���ҵ�һ������ʱ�����ҵĽ���
		  float temp=processes[0].arrivetime ;//��¼��С�ĵ���ʱ��
		  int k=0 ;//��־��ִ�еĽ���
		  for(int i=0;i<this.n;i++){//�ҵ��ﵽʱ������Ľ���
		   if(temp>processes[i].arrivetime){
		    temp=processes[i].arrivetime ;
		    k=i ;
		   }
		  }
		  this.finish=(int) temp ;//����finish�ĳ�ʼֵΪ��������Ľ��̵ĵ���ʱ��
		  this.set(k) ;
		  while(this.finishnum!=this.n){
		   float min=1000f ;int flag=0 ;
		   for(int i=0;i<n;i++){//���ݷ���ʱ�����ԭ���ҵ���ִ�еĽ���
		    if(this.processes[i].flag==0 && this.processes[i].arrivetime<=finish){
		     //���̻�ûִ�У������Ѿ�����
		     if(min>this.processes[i].servetime){
		      min=this.processes[i].servetime ;
		      k=i ;
		      flag=1 ;
		     }
		    }
		   }
		   if(flag==0){
		    this.finish++ ;
		   }else{
		    this.set(k) ;
		    }
		  }
		  for (int i=0;i<this.n;i++ ){
		   this.aveturnovertime+=processes[i].turnovertime ;
		  }
		  this.aveturnovertime/=this.n ;
		  for (int i=0;i<this.n;i++ ){
		   this.aveweighturnovertime+=processes[i].weighturnovertime ;
		  }
		  this.aveweighturnovertime/=this.n ;
		 }
		 public void set(int i){//����һ�����̵����ʱ�䣬��תʱ�䣬��Ȩ��תʱ��
		  this.setFinish(this.processes[i].servetime) ;
		  this.processes[i].setFinishtime(finish) ;
		  this.processes[i].setTurnovertime() ;
		  this.processes[i].setWeighturnovertime() ;
		  this.processes[i].setFlag() ;//�������
		  this.finishnum++ ;
		 }
		 public void print(){//��ӡ���
		  for(int i=0;i<this.n;i++){
		   System.out.print(this.processes[i]) ;
		  }
//		  System.out.println("ƽ����תʱ�䣺" +this.aveturnovertime) ;
//		  System.out.println("ƽ����Ȩ��תʱ�䣺" + this.aveweighturnovertime) ;
		 }
		
		 
		  

		

}
