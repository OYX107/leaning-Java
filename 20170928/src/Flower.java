
public class Flower {
	public static void main(String args[]){
		int a,b,c;
		for(int i=100;i<999;i++){
			a=i/100;
			b=i%100/10;
			c=i%100%10;
			if((a*a*a+b*b*b+c*c*c)==i){
				System.out.print(i+", ");
			}
		}
	}

}
