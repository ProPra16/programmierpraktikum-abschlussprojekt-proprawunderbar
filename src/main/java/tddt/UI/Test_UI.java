
package tddt.UI;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tddt.code.Compile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test_UI {
	private static Stage stage = new Stage();
	private static int width = 1750;
	private static int height = 1000;
	static TextArea testCode = new TextArea();
	static TextArea sourceCode = new TextArea();
	public static TextArea compileOutput = new TextArea();
	private static String status = "writeTest";
	public static Text a = new Text("");


	public static void runTestUI(String x) throws IOException {
		BorderPane borderPane = new BorderPane();
		GridPane text = new GridPane();

		String input= new String(String.valueOf(Files.readAllLines(Paths.get(x+"Aufgabenstellung.txt"))));
		String input2 = input.substring(1, input.length()-1);
		a.setText(input2);

		DropShadow shadow = new DropShadow();
		shadow.setOffsetY(3.0f);
		shadow.setColor(Color.DARKGRAY);

		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setOffsetX(0.5f);
		innerShadow.setOffsetY(0.5f);
		innerShadow.setColor(Color.BLACK);

		Blend blend= new Blend();
		blend.setMode(BlendMode.MULTIPLY);
		blend.setBottomInput(shadow);
		blend.setTopInput(innerShadow);

		GridPane buttons = new GridPane();
		Button save = new Button("Speichern");
		save.setPrefSize(500,30);
		save.setFont(Font.font("Verdana",20));
		save.setEffect(shadow);
		save.setCache(true);
		save.setStyle("-fx-font-weight: bold;");

		Button compile = new Button("Kompilieren");
		compile.setOnAction(e -> {
					System.out.println("Hallo Welt!");
			      	Compile.compile(sourceCode.getText(),"HalloWelt", testCode.getText(), "HalloWeltTest",status);
		});
		compile.setPrefSize(500,30);
		compile.setFont(Font.font("Verdana",20));
		compile.setEffect(shadow);
		compile.setCache(true);
		compile.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");

		Button test = new Button("Zurück");
		test.setPrefSize(500,30);
		test.setFont(Font.font("Verdana",20));
		test.setEffect(shadow);
		test.setCache(true);
		test.setStyle("-fx-font-weight: bold;");

		a.setFont(Font.font("Verdana", 30));
		a.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		a.setFill(Color.DARKGRAY);
		a.setEffect(blend);
		a.setCache(true);
		text.setAlignment(Pos.CENTER);
		text.setPadding(new Insets(25,25,25,25));
		text.add( a , 1,1,1,1);

		GridPane center = new GridPane();
		center.setPadding(new Insets(0,25,0,15));

		Text tests = new Text("Tests:");
		tests.setFont(Font.font("Verdana", 20));
		tests.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		tests.setFill(Color.DARKGRAY);
		tests.setEffect(blend);
		tests.setCache(true);

		Text source = new Text("Code:");
		source.setFont(Font.font("Verdana",20));
		source.setStyle("-fx-font-weight: bold; -fx-base: #FFFFFF");
		source.setFill(Color.DARKGRAY);
		source.setEffect(blend);
		source.setCache(true);

		center.add(tests, 0, 0);
		center.add(source, 1, 0);
		center.setHgap(10);
		center.setVgap(10);

		sourceCode.setMinWidth((width/2)-25);
		sourceCode.setMinHeight(height-380);
		sourceCode.setEffect(blend);
		sourceCode.setCache(true);

		testCode.setMinWidth((width/2)-25);
		testCode.setMinHeight(height-380);
		testCode.setEffect(blend);
		testCode.setCache(true);

		compileOutput.setMinWidth(width-60);
		compileOutput.setMaxHeight(540);
		compileOutput.setEffect(blend);
		compileOutput.setCache(true);
		compileOutput.setEditable(false);
	
		String s = "";
		testCode.setText(s);
//		sourceCode.setEditable(false);
		center.add(testCode, 0, 1);
		center.add(sourceCode, 1, 1);
		center.add(compileOutput, 0, 2, 2, 1);

		borderPane.setCenter(center);
		borderPane.setTop(text);
		borderPane.setBottom(buttons);
		borderPane.setStyle("-fx-background-color: #E0E0E0");


		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setPadding(new Insets(20));
		buttons.add(save,0,1);
		buttons.add(compile,1,1);
		buttons.add(test,2,1);

		stage.setScene(new Scene(borderPane, width, height));
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Übung"+x);
		stage.show();
	}
	public static void switchStatus(){
		if(status.equals("writeTest")){
			status = "fixTest";
			testCode.setEditable(false);
			testCode.setStyle("-fx-background-color: #E0E0E0");//Farbe wählen
			sourceCode.setEditable(true);
			sourceCode.setStyle("-fx-background-color: #E0E0E0");//Farbe wählen
			a.setText("Bitte überarbeiten Sie ihr Programm, sodass alle Tests laufen!");
		}
		else if(status.equals("fixTest")){
			status = "writeTest";
			testCode.setEditable(true);
			testCode.setStyle("-fx-background-color: #E0E0E0");//Farbe wählen
			sourceCode.setEditable(false);
			sourceCode.setStyle("-fx-background-color: #E0E0E0");//Farbe wählen
			a.setText("Bitte geben sie einen fehlschlagenden Test ein!");
		}
    }

}