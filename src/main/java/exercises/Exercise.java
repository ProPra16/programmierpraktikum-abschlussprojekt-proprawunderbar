package exercises;

public class Exercise {
	public String className;
	public String classCode;
	public String testName;
	public String testCode;
	public boolean babystep;
	public boolean timetracker;
	public double time;
	public Exercise(String className, String classCode, String testName, String testCode, boolean babystep, boolean timetracker){
		this.className = className;
		this.classCode = classCode;
		this.testName = testName;
		this.testCode = testCode;
		this.babystep = babystep;
		this.timetracker = timetracker;
	}
	public Exercise(String className, String classCode, String testName, String testCode, boolean babystep, boolean timetracker, double time){
		this.className = className;
		this.classCode = classCode;
		this.testName = testName;
		this.testCode = testCode;
		this.babystep = babystep;
		this.timetracker = timetracker;
		this.time=time;
	}
}
