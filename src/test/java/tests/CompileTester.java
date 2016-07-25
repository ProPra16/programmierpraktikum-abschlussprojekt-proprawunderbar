package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import exercises.Exercise;
import tddt.code.Compile;


public class CompileTester {

    static List<Exercise> testlist;
    
    public List<Exercise> readTests() throws ParserConfigurationException, SAXException, IOException {
		String className = "failure";
		String classCode = "failure";
		String testName = "failure";
		String testCode = "failure";
		String exerciseName = "failure";
		String description = "failure";
		boolean babystep = false;
		boolean timetracking = false;
		int time = 0;
		
		
		List<Exercise> exercises = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		URL url = getClass().getResource("/Tests" + ".xml");
		System.out.println(url.getFile());
		Document doc = builder.parse(new File(url.getFile()));
		Element root = doc.getDocumentElement();
		NodeList list = root.getElementsByTagName("exercise");
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				exerciseName = element.getAttribute("name");
				description = element.getElementsByTagName("description").item(0).getTextContent();
			
				NodeList classes = element.getElementsByTagName("classes");
				Node classNode = classes.item(0);
				if (classNode.getNodeType() == Node.ELEMENT_NODE) {
					Element classesElement = (Element) classNode;
					Element classElement = (Element) classesElement.getElementsByTagName("class").item(0);
					className = classElement.getAttribute("name");
					classCode = classesElement.getElementsByTagName("class").item(0).getTextContent();
				}
				NodeList tests = element.getElementsByTagName("tests");
				Node testNode = tests.item(0);
				if (testNode.getNodeType() == Node.ELEMENT_NODE) {
					Element testsElement = (Element) testNode;
					Element testElement = (Element) testsElement.getElementsByTagName("test").item(0);
					testName = testElement.getAttribute("name");
					testCode = testsElement.getElementsByTagName("test").item(0).getTextContent();
				}
				NodeList config = element.getElementsByTagName("config");
				Node configNode = config.item(0);
				if(configNode.getNodeType() == Node.ELEMENT_NODE){
					Element configElement = (Element) configNode;
					Element babystepElement = (Element) configElement.getElementsByTagName("babysteps").item(0);
						babystep = babystepElement.getAttribute("value").equals("True");
					
					if(babystep){
						time = Integer.parseInt(babystepElement.getAttribute("time"));
					}
					Element timetrackerElement = (Element) configElement.getElementsByTagName("timetracking").item(0);
					timetracking = timetrackerElement.getAttribute("value").equals("True");
				}
				
			}
			if(!babystep){
				Exercise e = new Exercise(className, classCode, testName, testCode, babystep, timetracking, exerciseName,description);
				exercises.add(i, e);
			}
			else{
				Exercise e = new Exercise(className, classCode, testName, testCode, babystep, timetracking,time, exerciseName,description);
				exercises.add(i, e);
			}
			
		}
		
		
		return exercises;
	}
    
    
    
    @Test
      public void compileFail() throws Exception {
    	testlist = readTests();
        Exercise TestExercise = testlist.get(0) ;
        Compile.compile(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
        assertEquals(Compile.compilerResult.hasCompileErrors(), true);
    }
      
    @Test
    public void compileSuccess() throws Exception {
    	Exercise TestExercise = testlist.get(1) ;
    	Compile.compile(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
    	assertEquals(Compile.compilerResult.hasCompileErrors(), false);
  } 
    
    
    //hier sollen alle Tests stimmen
    @Test
    public void test0Misses() throws Exception {
    	Exercise TestExercise = testlist.get(1) ;
    	Compile.runTests(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
        assertEquals(Compile.failedTests, 0);
  } 
    
   //hier solle der Test fehlschlagen
    @Test
    public void test1Miss() throws Exception {
    	Exercise TestExercise = testlist.get(1) ;
    	Compile.runTests(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
    	assertEquals(Compile.failedTests, 1);
  } 
}

