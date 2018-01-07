# 实验二 JAVA控制语句
## 一、判断闰年
编写Java程序，输出从公元1990年到2007年所有
闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。
#### 主要代码

```
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
```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/44b0fa008191308b89efda320d4dd5fe/0)

## 二、百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
- 优：[90,100]
- 良：[89,80]
- 中：[79,70]
- 及格：[69,60]
- 不及格：[0,59]

#### 主要代码

```

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
		int [] grade = {85,90,77,50,66,23
};
//		String [] grades = new String[grade.length];
		for(int i=0;i<grade.length;i++){
			change(grade[i]);
		}
	}

}

```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/2546237dd7009bb153ad32dd52f95347/0)
## 三、打印图案

```
利用for循环编写一个程序，将如下图案分别打印输
出。
      *
    ***
  *****
*******
  *****
    ***
      *
```

#### 主要代码

```

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

```
#### 实验结果
![image](https://qqadapt.qpic.cn/txdocpic/0/0f2dc88d4dea9633d4707a733923ba1d/0)
## 四、水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
#### 主要代码

```
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
```
#### 实验截图
![image](https://qqadapt.qpic.cn/txdocpic/0/6b4cefc457b5f2e4efef396624351d71/0)