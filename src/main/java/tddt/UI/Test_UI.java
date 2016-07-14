
package tddt.UI;

import java.io.IOException;

import exercises.Exercise;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tddt.code.Compile;
import tddt.code.Timer;

public class Test_UI {
	private static Stage stage = new Stage();
	private static int width = 1750;
	private static int height = 1000;
	static TextArea testCode = new TextArea();
	static TextArea sourceCode = new TextArea();
	public static TextArea compileOutput = new TextArea();
	public static String status = "writeTest";
	public static Text titel = new Text("");
	public static String sourceBackup;
	public static String testBackup;
	public static Text timerText = new Text();
	public static Timer timer;

	public static void runTestUI(Exercise exercise) throws IOException {
		timer = new Timer(timerText, exercise.babystep, exercise.time);

		timer.start();
		BorderPane borderPane = new BorderPane();
		GridPane text = new GridPane();
		sourceBackup = exercise.classCode;
		testBackup = exercise.testCode;

		titel.setText(exercise.description);

		DropShadow shadow = new DropShadow();
		shadow.setOffsetY(3.0f);
		shadow.setColor(Color.DARKGRAY);

		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setOffsetX(0.5f);
		innerShadow.setOffsetY(0.5f);
		innerShadow.setColor(Color.BLACK);

		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);
		blend.setBottomInput(shadow);
		blend.setTopInput(innerShadow);

		GridPane buttons = new GridPane();
		Button refactor = new Button("Refactor");
		refactor.setPrefSize(500, 30);
		refactor.setFont(Font.font("Verdana", 20));
		refactor.setEffect(shadow);
		refactor.setCache(true);
		refactor.setStyle("-fx-font-weight: bold;");
		refactor.setOnAction(e -> {
			if(status.equals("writeTest")){
			sourceBackup = sourceCode.getText();
			testCode.setText(testBackup);
			switchStatus();
			titel.setText("Refactoring");
			}
			else {
				compileOutput.setText("");
		      	Compile.runTests(sourceCode.getText(),exercise.className, testCode.getText(), exercise.testName,compileOutput);
			}
		});
		Button compile = new Button("Kompilieren");
		compile.setOnAction(e -> {
//					System.out.println("Hallo Welt!");
					compileOutput.setText("");
			      	Compile.runTests(sourceCode.getText(),exercise.className, testCode.getText(), exercise.testName,compileOutput);
			      	

		});
		System.out.println(exercise.className);
		System.out.println(exercise.testName);
		compile.setPrefSize(500, 30);
		compile.setFont(Font.font("Verdana", 20));
		compile.setEffect(shadow);
		compile.setCache(true);
		compile.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");

		Button returnButton = new Button("Zurück");
		returnButton.setPrefSize(500, 30);
		returnButton.setFont(Font.font("Verdana", 20));
		returnButton.setEffect(shadow);
		returnButton.setCache(true);
		returnButton.setStyle("-fx-font-weight: bold;");
		returnButton.setOnAction(e -> {
			if (status.equals("fixTest"))
				returnToTest();

		});

		titel.setFont(Font.font("Verdana", 30));
		titel.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		titel.setFill(Color.DARKGRAY);
		titel.setEffect(blend);
		titel.setCache(true);
		text.setAlignment(Pos.CENTER);
		text.setPadding(new Insets(25, 25, 25, 25));
		text.add(titel, 1, 1, 1, 1);

		GridPane center = new GridPane();
		center.setPadding(new Insets(0, 25, 0, 15));

		Text tests = new Text("Tests:");
		tests.setFont(Font.font("Verdana", 20));
		tests.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		tests.setFill(Color.DARKGRAY);
		tests.setEffect(blend);
		tests.setCache(true);

		Text source = new Text("Code:");
		source.setFont(Font.font("Verdana", 20));
		source.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		source.setFill(Color.DARKGRAY);
		source.setEffect(blend);
		source.setCache(true);

		Button color1 = new Button();
		color1.setPrefSize(40, 40);
		if (!color1.equals("-fx-base: #FFFFFF")) {
			// hier die Abbruchbedingung
		}
		Button color2 = new Button();
		if (!color2.equals("-fx-base: #FFFFFF")) {
			// hier die Abbruchbedingung
		}
		color2.setPrefSize(40, 40);

		center.add(tests, 0, 0);
		center.add(source, 1, 0);
		center.setHgap(10);
		center.setVgap(10);

		sourceCode.setMinWidth((width / 2) - 25);
		sourceCode.setMinHeight(height - 380);
		sourceCode.setEffect(blend);
		sourceCode.setCache(true);
		sourceCode.setText(exercise.classCode);

		testCode.setMinWidth((width / 2) - 25);
		testCode.setMinHeight(height - 380);
		testCode.setEffect(blend);
		testCode.setCache(true);
		testCode.setText(exercise.testCode);

		compileOutput.setMinWidth(width - 60);
		compileOutput.setMaxHeight(540);
		compileOutput.setEffect(blend);
		compileOutput.setCache(true);
		compileOutput.setEditable(false);

		// sourceCode.setEditable(false);
		center.add(testCode, 0, 1);
		center.add(sourceCode, 1, 1);
		center.add(compileOutput, 0, 2, 2, 1);

		borderPane.setCenter(center);
		borderPane.setTop(text);
		borderPane.setBottom(buttons);
		borderPane.setStyle("-fx-background-color: #E0E0E0");

		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setPadding(new Insets(20));
		buttons.add(color1, 0, 1);
		buttons.add(refactor, 1, 1);
		buttons.add(compile, 2, 1);
		buttons.add(returnButton, 3, 1);
		buttons.add(color2, 4, 1);
		
		stage.setOnCloseRequest(e -> {timer.kill();});
		stage.setScene(new Scene(borderPane, width, height));
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Übung: " + exercise.exerciseName);
		stage.show();
	}

	public static void switchStatus() {
		timer.setTo(0);
		if (status.equals("writeTest")) {
			sourceBackup = sourceCode.getText();
			testBackup = testCode.getText();
			status = "fixTest";

			testCode.setEditable(false);
			testCode.setStyle("-fx-background-color: #E0E0E0"); // Farbe waehlen
			sourceCode.setEditable(true);
			sourceCode.setStyle("-fx-background-color: #E0E0E0"); // Farbe
																	// waehlen
			titel.setText("Bitte überarbeiten Sie ihr Programm, sodass alle Tests laufen!");
		}

		else if (status.equals("fixTest")) {
			sourceBackup = sourceCode.getText();
			testBackup = testCode.getText();
			status = "writeTest";

			testCode.setEditable(true);
			testCode.setStyle("-fx-background-color: #E0E0E0"); // Farbe waehlen
			sourceCode.setEditable(false);
			sourceCode.setStyle("-fx-background-color: #E0E0E0"); // Farbe
																	// waehlen
			titel.setText("Bitte geben sie einen fehlschlagenden Test ein!");
		}
	}

	public static void returnToTest() {
		sourceCode.setText(sourceBackup);
		switchStatus();
	}

	public static void reset() {
		System.out.println("Hallo");
		if (status.equals("fixTest")) {
			sourceCode.setText(sourceBackup);
			timer.reset();
		}

		else if (status.equals("writeTest")) {
			testCode.setText(testBackup);
			timer.reset();
		}
	}

}
