
public class ToGradeScore {
	public static void change(int grade){
		if(grade>=0 && grade<60){
			System.out.println(" ������");
		}else if(grade>=60 && grade<=69){
			System.out.println(" ����");
		}else if(grade>=70 && grade<=79){
			System.out.println(" ��");
		}else if(grade>=80 && grade<=89){
			System.out.println(" ��");
		}else if(grade>=90 && grade<=100){
			System.out.println(" ��");
		}else{
			System.out.println("�������");
		}
	}
	public static void main(String[] args){
		int [] grade = {
};
		//String [] grades = new String[grade.length];
		for(int i=0;i<grade.length;i++){
			change(grade[i]);
		}
	}

}
