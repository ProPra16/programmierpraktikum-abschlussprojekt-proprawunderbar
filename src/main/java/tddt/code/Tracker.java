package tddt.code;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
	
	public static String status = "test";
	
	public class Times {
		public int code = 0;
		public int test = 0;
		public Times(){}
	}
	
	public static List<Times> times = new ArrayList<Times>();
	public static List<Integer> testTimes = new ArrayList<>();
	public static List<Integer> codeTimes = new ArrayList<>();
	public static int runs = 0;
	
	public class Timer {
		
		boolean clocking = false;
		boolean running = true;
		
		Thread clock = new Thread(() -> {
			while (running) {
				while (clocking) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						
					}
					if (status == "code") {
				//		temp.code++;
					}
					else if (status == "test") {
					//	temp.test++;
					}
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					
				}
			}
		});
	}
	
	
	public static void displayTimes() {
		if (times.size() == 0) return;
		for (int i = 0; i < times.size(); i++) {
			
			System.out.println("Das Schreiben des " + i+1 + ". Tests hat " + times.get(i).test + " Sekunden gedauert.");
			System.out.println("Das Schreiben des " + i+1 + ". Codes hat " + times.get(i).code + " Sekunden gedauert.");
		}
	}
	
	public static void switchStatus() {
		if (status == "code"){
		//	times.add(temp);
			//temp.code = 0;
		//	temp.test = 0;
			status = "test";
		}
		
		else if (status == "test"){
			status = "code";
		}
	}
}
