package tddt.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tddt.code.Compile;

public class Test_UI {
    public static Stage stage = new Stage();
    public static int width = 1750;
    public static int height = 1000;
    static TextArea testCode = new TextArea();
	static TextArea sourceCode = new TextArea();
	public static String status = "writeTest";
	public static Text a = new Text("Bitte geben sie einen fehlschlagenden Test ein!");

    
    public static void runTestUI() {
    	BorderPane borderPane = new BorderPane();
		GridPane text = new GridPane();

		GridPane buttons = new GridPane();
		Button save = new Button("Speichern");
		save.setPrefSize(500,30);
		save.setFont(Font.font("Verdana",20));
		Button compile = new Button("Kompilieren");
		   compile.setOnAction(e -> {
	        	Compile.compile(sourceCode.getText(),"HalloWelt", testCode.getText(), "HalloWeltTest",status);
	        });
		compile.setPrefSize(500,30);
		compile.setFont(Font.font("Verdana",20));
		Button test = new Button("Projekt Testen");
		test.setPrefSize(500,30);
		test.setFont(Font.font("Verdana",20));

		a.setFont(Font.font("Verdana", 25));
		text.setAlignment(Pos.CENTER);
		text.setPadding(new Insets(25,25,25,25));
		text.add( a , 1,1,1,1);
		
		GridPane center = new GridPane();
		Text tests = new Text("Tests:");
		a.setFont(Font.font("Verdana", 15));
		Text source = new Text("Code:");
		a.setFont(Font.font("Verdana", 15));
		center.add(tests, 0, 0);
		center.add(source, 1, 0);
		
		sourceCode.setMinWidth(width/2);
		sourceCode.setMinHeight(height-180);
		testCode.setMinWidth(width/2);
		testCode.setMinHeight(height-180);
		String s = "";
		testCode.setText(s);
//		sourceCode.setEditable(false);
		center.add(testCode, 0, 1);
		center.add(sourceCode, 1, 1);
		
		borderPane.setCenter(center);
		borderPane.setTop(text);
		borderPane.setBottom(buttons);


		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setPadding(new Insets(20));
		buttons.add(save,0,1);
		buttons.add(compile,1,1);
		buttons.add(test,2,1);

		stage.setScene(new Scene(borderPane, width, height));
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Tests schreiben");
		stage.show();
    }
    public static void switchStatus(){
    	if(status.equals("writeTest")){
    		status = "fixTest";
    		testCode.setEditable(false);
    		sourceCode.setEditable(true);
    		a.setText("Bitte überarbeiten Sie ihr Programm, sodass alle Tests laufen!");
    	}
    	else if(status.equals("fixTest")){
    		status = "writeTest";
    		testCode.setEditable(true);
    		sourceCode.setEditable(false);
    		a.setText("Bitte geben sie einen fehlschlagenden Test ein!");
    	}
    }
}