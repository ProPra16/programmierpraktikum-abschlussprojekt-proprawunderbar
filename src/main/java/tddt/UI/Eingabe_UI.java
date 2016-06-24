package tddt.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Eingabe_UI extends Application {
    public Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane borderPane = new BorderPane();
        GridPane text = new GridPane();

        GridPane buttons = new GridPane();
        Button save = new Button("Speichern");
        save.setPrefSize(500,30);
        save.setFont(Font.font("Verdana",20));
        Button compile = new Button("Kompilieren");
     
        compile.setPrefSize(500,30);
        compile.setFont(Font.font("Verdana",20));
        Button tests = new Button("Testen");
        tests.setPrefSize(500,30);
        tests.setFont(Font.font("Verdana",20));

        Text a = new Text("Bitte geben sie den auf ihren Test passenden Teil ihres Programms ein!");
        a.setFont(Font.font("Verdana", 25));
        text.setAlignment(Pos.CENTER);
        text.setPadding(new Insets(25,25,25,25));
        text.add( a , 1,1,1,1);

        borderPane.setTop(text);
        borderPane.setBottom(buttons);


        buttons.setAlignment(Pos.TOP_CENTER);
        buttons.setPadding(new Insets(20));
        buttons.add(save,0,1);
        buttons.add(compile,1,1);
        buttons.add(tests,2,1);

        stage.setScene(new Scene(borderPane, 1750, 1000));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Projekt");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}