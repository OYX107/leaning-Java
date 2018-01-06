import java.io.FileReader;
import java.util.Scanner;

public class Read {
	Task task[] = new Task[100];
	int count = 0;
	
	@SuppressWarnings("resource")
	public void read(String name)throws Exception{
		FileReader read = new FileReader(name);
		Scanner scanner = new Scanner(read);
		while(scanner.hasNext()){
			if(scanner.hasNextLine()){
				Task t = new Task(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				this.task[count] = t;
				count++;
			}
		}
//		FSFC fsfc = new FSFC();
		SJF s = new SJF();
//		s.fun(task,count);
//		s.fun2(task, count, 1);
		s.fun2(task, count, 2);
		
	}

}
