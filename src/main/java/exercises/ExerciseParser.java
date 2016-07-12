package exercises;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExerciseParser extends Application {
	public List<Exercise> readExercise() throws ParserConfigurationException, SAXException, IOException {
		String className = "failure";
		String classCode = "failure";
		String testName = "failure";
		String testCode = "failure";
		boolean babystep = false;
		boolean timetracking = false;
		double time = 0.0;
		
		
		List<Exercise> exercises = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		URL url = getClass().getResource("/Exercises" + ".xml");
		System.out.println(url.getFile());
		Document doc = builder.parse(new File(url.getFile()));
		Element root = doc.getDocumentElement();
		NodeList list = root.getElementsByTagName("exercise");
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
			
				NodeList classes = element.getElementsByTagName("classes");
				Node classNode = classes.item(0);
				if (classNode.getNodeType() == Node.ELEMENT_NODE) {
					Element classesElement = (Element) classNode;
					Element classElement = (Element) classesElement.getElementsByTagName("class").item(0);
					className = classElement.getAttribute("name");
					classCode = classesElement.getElementsByTagName("class").item(0).getTextContent();
//					System.out.println("Class Name: "+className);
//					System.out.println("Code: "+classCode);
				}
				NodeList tests = element.getElementsByTagName("tests");
				Node testNode = tests.item(0);
				if (testNode.getNodeType() == Node.ELEMENT_NODE) {
					Element testsElement = (Element) testNode;
					Element testElement = (Element) testsElement.getElementsByTagName("test").item(0);
					testName = testElement.getAttribute("name");
					testCode = testsElement.getElementsByTagName("test").item(0).getTextContent();
//					System.out.println("Test Name: " +testName);
//					System.out.println("Test Code: "+testCode);
				}
				NodeList config = element.getElementsByTagName("config");
				Node configNode = config.item(0);
				if(configNode.getNodeType() == Node.ELEMENT_NODE){
					Element configElement = (Element) configNode;
					Element babystepElement = (Element) configElement.getElementsByTagName("babysteps").item(0);
						babystep = babystepElement.getAttribute("value").equals("True");
					
					if(babystep){
						time = Double.parseDouble(babystepElement.getAttribute("time"));
					}
					Element timetrackerElement = (Element) configElement.getElementsByTagName("timetracking").item(0);
					timetracking = timetrackerElement.getAttribute("value").equals("True");
//					System.out.print("Babystep: "+babystep);
//					System.out.println("  Time: "+time);
//					System.out.println("Timetracking: "+timetracking);
				}
				
			}
			if(!babystep){
				Exercise e = new Exercise(className, classCode, testName, testCode, babystep, timetracking);
				exercises.add(i, e);
			}
			else{
				Exercise e = new Exercise(className, classCode, testName, testCode, babystep, timetracking,time);
				exercises.add(i, e);
			}
			
		}
		
		
		return exercises;
	}

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		readExercise();
	}
}
