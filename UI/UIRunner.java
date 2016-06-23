package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UIRunner extends Application {
    public Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button Neues_Projekt = new Button("Neues Projekt erstellen");
        Button Laden = new Button("Projekt laden");
        Button Beenden = new Button("Beenden");
        Neues_Projekt.setPrefSize(200,30);
        Laden.setPrefSize(200,30);
        Beenden.setPrefSize(200,30);

        GridPane root = new GridPane();
        GridPane title = new GridPane();
        GridPane empty_space = new GridPane();
        GridPane empty_space2 = new GridPane();
        GridPane empty_space3 = new GridPane();

        BorderPane border = new BorderPane();
        border.setTop(title);
        border.setLeft(empty_space);
        border.setRight(empty_space2);
        border.setCenter(root);
        border.setBottom(empty_space3);

        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(25,25,25,25));
        root.add(Neues_Projekt, 0,1);
        root.add(Laden, 0, 2);
        root.add(Beenden , 0 , 3);

        Text text = new Text("Willkommen!");
        text.setFont(Font.font("Verdana", 30));

        title.setAlignment(Pos.BOTTOM_CENTER);
        title.setPadding(new Insets(25,25,25,25));
        title.add(text, 0 , 6);


        stage.setScene(new Scene(border, 400, 300));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Test-Driven-Development-Trainer");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
