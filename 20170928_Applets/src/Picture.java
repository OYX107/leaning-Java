
public class Picture {
	public static void main(String [] args){
		for(int i=1;i<14;i=i+2){
			if(i<=7){
				for(int j=7;j>0;j--){
					if(j<=i){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			if(i>7){
				for(int j=0;j<7;j++){
					if(j>=i-7){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
