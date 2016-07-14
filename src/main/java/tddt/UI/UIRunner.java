
package tddt.UI;

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

import exercises.Exercise;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tddt.code.Loader;


public class UIRunner extends Application {
    public Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
    
        Button Neues_Projekt = new Button("Neue Übung Auswählen");
        
        List<Exercise> exercises = readExercise();
        Neues_Projekt.setOnAction(e -> {
            try {
            	
            	Loader.ask(exercises);}
            catch (Exception ex) {}
        	stage.close();
        });

        Button Laden = new Button("Zuletzt verwendete Übung laden");
        Laden.setOnAction(e -> {
            try {
				Loader.ask(exercises);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            stage.close();
        });

        Button Beenden = new Button("Beenden");
        Beenden.setOnAction(e -> {
            stage.close();
        });
        Blend blend = new Blend();
        shadowandinner(blend);

        design(Neues_Projekt,blend);
        design(Laden,blend);
        design(Beenden,blend);

        BorderPane border = new BorderPane();
        decorate(border,Neues_Projekt,Laden,Beenden,blend);

        stage.setScene(new Scene(border, 440, 350));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Test-Driven-Development-Trainer");
        stage.show();
    }

    public void design(Button button, Blend blend){
        button.setPrefSize(250, 40);
        button.setEffect(blend);
        button.setStyle("-fx-font: 13 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
    }

    public void decorate(BorderPane border, Button Neues_Projekt, Button Laden, Button Beenden, Blend blend){
        GridPane root = new GridPane();
        GridPane title = new GridPane();
        GridPane empty_space = new GridPane();
        GridPane empty_space2 = new GridPane();
        GridPane empty_space3 = new GridPane();

        border.setTop(title);
        border.setLeft(empty_space);
        border.setRight(empty_space2);
        border.setCenter(root);
        border.setBottom(empty_space3);
        border.setStyle("-fx-background-color: #E0E0E0");

        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(Neues_Projekt, 0, 0);
        root.setVgap(10);
        root.add(Laden, 0, 1);
        root.add(Beenden, 0, 2);

        Text text = new Text("Willkommen!");
        text.setFont(Font.font("Verdana", FontPosture.ITALIC, 35));
        text.setStyle("-fx-font-weight: bold;");
        text.setFill(Color.BLACK);
        text.setEffect(blend);
        text.setCache(true);


        title.setAlignment(Pos.BOTTOM_CENTER);
        title.setPadding(new Insets(25, 25, 25, 25));
        title.add(text, 0, 6);
    }

    public void shadowandinner(Blend blend){
        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(7.0f);
        shadow.setColor(Color.DARKGRAY);

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(1.0f);
        innerShadow.setOffsetY(1.0f);
        innerShadow.setColor(Color.LIGHTGRAY);

        blend.setMode(BlendMode.MULTIPLY);
        blend.setBottomInput(shadow);
        blend.setTopInput(innerShadow);
    }
    
    public List<Exercise> readExercise() throws ParserConfigurationException, SAXException, IOException {
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

		URL url = getClass().getResource("/Exercises" + ".xml");
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
						time = Integer.parseInt(babystepElement.getAttribute("time"));
					}
					Element timetrackerElement = (Element) configElement.getElementsByTagName("timetracking").item(0);
					timetracking = timetrackerElement.getAttribute("value").equals("True");
//					System.out.print("Babystep: "+babystep);
//					System.out.println("  Time: "+time);
//					System.out.println("Timetracking: "+timetracking);
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
}