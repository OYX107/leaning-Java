
public class Year {
	public static void main(String args[]){
		int num = 0;
		for(int i=1990;i<=2007;i++){
			if((i%4==0 && i%100!=0)||(i%400==0)){
				num++;
				if(num%2==0){
					System.out.println(i);
				}else{
					System.out.print(i+"   ");
				}
			}
		}
	}

}
