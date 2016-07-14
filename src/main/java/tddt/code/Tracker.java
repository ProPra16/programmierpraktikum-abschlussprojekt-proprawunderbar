package tddt.code;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
	
	public static String status = "test";
	
	/*public class Times {
		public int code = 0;
		public int test = 0;
		public Times(){}
	}*/
	
	public static List<Integer> code = new ArrayList<>();
	public static List<Integer> test = new ArrayList<>();
	//public static List<Times> times = new ArrayList<Times>();
	
	//public Times temp = new Times();
	static int codeTemp = 0;
	static int testTemp = 0;
	
	static boolean clocking = true;
	static boolean running = true;
	
	public static void startTimer() {
		System.out.println("Hallo");
		new Thread(() -> {
			while (running) {
				
				while (clocking) {
				
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (status.equals("code")) {
						codeTemp++;
					}
					else if (status.equals("test")) {
						testTemp++;
					}
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					
				}
			}
		}).start();
	}
	
	
	public static void displayTimes() {
		if (code.size() == 0 || test.size() == 0) return;
		System.out.println("Da");
		for (int i = 0; i < code.size(); i++) {
			//Times printTemp = new Times();
			//printTemp = times.get(i);
			
			System.out.println("Das Schreiben des " + (i+1) + ". Tests hat " + test.get(i) + " Sekunden gedauert.");
			System.out.println("Das Schreiben des " + (i+1) + ". Codes hat " + code.get(i) + " Sekunden gedauert.");
		}
	}
	
	public static void switchStatus(	) {
		if (status == "code"){
			//times.add(temp);
			code.add(codeTemp);
			test.add(testTemp);
			codeTemp = 0;
			testTemp = 0;
			status = "test";
		}
		
		else if (status == "test"){
			status = "code";
		}
	}
	
	public static void kill() {
		running = false;
		clocking = false;
	}
}
