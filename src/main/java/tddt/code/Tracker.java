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
	public Times temp = new Times();
	
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
						temp.code++;
					}
					else if (status == "test") {
						temp.test++;
					}
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					
				}
			}
		});
	}
	
	
	public void displayTimes() {
		if (times.size() == 0) return;
		for (int i = 0; i < times.size(); i++) {
			Times printTemp = new Times();
			printTemp = times.get(i);
			System.out.println("Das Schreiben des " + i+1 + ". Tests hat " + printTemp.test + " Sekunden gedauert.");
			System.out.println("Das Schreiben des " + i+1 + ". Codes hat " + printTemp.code + " Sekunden gedauert.");
		}
	}
	
	public void switchStatus() {
		if (status == "code"){
			times.add(temp);
			temp.code = 0;
			temp.test = 0;
			status = "test";
		}
		
		else if (status == "test"){
			status = "code";
		}
	}
}
