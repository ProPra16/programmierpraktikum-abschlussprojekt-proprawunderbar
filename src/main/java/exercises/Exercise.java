package exercises;

public class Exercise {
	String className;
	String classCode;
	String testClassName;
	String testClassCode;
	boolean babystep;
	boolean timetracker;
	public Exercise(String className, String classCode, String testClassName, String testClassCode, boolean babystep, boolean timetracker){
		this.className = className;
		this.classCode = classCode;
		this.testClassName = testClassName;
		this.testClassCode = testClassCode;
		this.babystep = babystep;
		this.timetracker = timetracker;
	}
}
