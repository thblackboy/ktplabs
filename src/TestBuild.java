import java.util.Scanner;
import java.lang.Thread;
public class TestBuild {
	
public static int sec=0;
public static int min=0;
public static int hour=0;	
static boolean on = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		 Runnable proctime = new Runnable() { // описываем объект Runnable в конструкторе
             public void run() {
             	sec=min=hour=0;
             	while(on) 
         		{ 
         			sec++;
         			if (sec==60)
         			{
         				sec=0;
         				min++;
         			}
         			if (min==60) {
         				min=0;
         				hour++;
         			}
         			try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
         		}
             	System.out.print("Time is stopped");
             }
         };
         
		 Scanner in = new Scanner(System.in);
		 String comd="";
		 Thread myThread=new Thread(proctime);
		 while(!comd.equals("/exit")) {
		System.out.println("/start - Start time \n /show - Show time \n /stop - stop time ");
		
		comd = in.next();
		switch(comd) {
		case "/start": if (!myThread.isAlive()) {
			myThread = new Thread(proctime);
			on=true;
			myThread.start();
		System.out.println("Start time");
		}
		else 
			System.out.print("Time is already started");
		break;
		case "/show":if (myThread.isAlive()) {
			System.out.printf("%d:%d:%d",hour,min,sec);
		}
		else
			System.out.println("Time is not started");
		break;
		case "/stop":
			//Thread.sleep(1000);
			//myThread.interrupt();
		System.out.println("Stop time");
		on=false;
		break;	
		}
		 }
		 System.out.println("thanks for using our soft");
		on=false;
		//	System.out.println();
			//System.out.printf("%d:%d:%d",hour,min,sec);
		

		

	}

}
