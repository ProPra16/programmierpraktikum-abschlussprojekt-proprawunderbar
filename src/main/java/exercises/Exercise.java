package exercises;

public class Exercise {
	public String exerciseName;
	public String description;
	public String className;
	public String classCode;
	public String testName;
	public String testCode;
	public boolean babystep;
	public boolean timetracker;
	public int time = 0;
	public Exercise(String className, String classCode, String testName, String testCode, boolean babystep, boolean timetracker, String exerciseName, String description){
		this.className = className;
		this.classCode = classCode;
		this.testName = testName;
		this.testCode = testCode;
		this.babystep = babystep;
		this.timetracker = timetracker;
		this.exerciseName = exerciseName;
		this.description = description;
	}
	public Exercise(String className, String classCode, String testName, String testCode, boolean babystep, boolean timetracker, int time, String exerciseName, String description){
		this.className = className;
		this.classCode = classCode;
		this.testName = testName;
		this.testCode = testCode;
		this.babystep = babystep;
		this.timetracker = timetracker;
		this.time=time;
		this.exerciseName = exerciseName;
		this.description = description;
	}
}
