
public class ToGradeScore {
	public static void change(int grade){
		if(grade>=0 && grade<60){
			System.out.println(" 不及格");
		}else if(grade>=60 && grade<=69){
			System.out.println(" 及格");
		}else if(grade>=70 && grade<=79){
			System.out.println(" 中");
		}else if(grade>=80 && grade<=89){
			System.out.println(" 良");
		}else if(grade>=90 && grade<=100){
			System.out.println(" 优");
		}else{
			System.out.println("输入错误！");
		}
	}
	public static void main(String[] args){
		int [] grade = {93,84,65,77,33};
		//String [] grades = new String[grade.length];
		for(int i=0;i<grade.length;i++){
			change(grade[i]);
		}
	}

}
