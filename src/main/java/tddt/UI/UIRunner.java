package tddt.UI;

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


public class UIRunner extends Application {
    public Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button Neues_Projekt = new Button("Neue Übung Auswählen");
        Neues_Projekt.setOnAction(e -> {
        	Test_UI.runTestUI();
        	stage.close();
        });

        Button Laden = new Button("Zuletzt verwendete Übung laden");
        Laden.setOnAction(e -> {
            //Loader.load();
            stage.close();
        });

        Button Beenden = new Button("Beenden");
        Beenden.setOnAction(e -> {
            stage.close();
        });

        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(7.0f);
        shadow.setColor(Color.DARKGRAY);

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(1.0f);
        innerShadow.setOffsetY(1.0f);
        innerShadow.setColor(Color.LIGHTGRAY);

        Blend blend= new Blend();
        blend.setMode(BlendMode.MULTIPLY);
        blend.setBottomInput(shadow);
        blend.setTopInput(innerShadow);

        Neues_Projekt.setPrefSize(250,40);
        Neues_Projekt.setEffect(blend);
        Neues_Projekt.setStyle("-fx-font: 13 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");

        Laden.setPrefSize(250,40);
        Laden.setEffect(blend);
        Laden.setStyle("-fx-font: 13 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");

        Beenden.setPrefSize(250,40);
        Beenden.setEffect(blend);
        Beenden.setStyle("-fx-font: 13 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");


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
        border.setStyle("-fx-background-color: #E0E0E0");

        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(25,25,25,25));
        root.add(Neues_Projekt, 0,0);
        root.setVgap(10);
        root.add(Laden, 0, 1);
        root.add(Beenden , 0 , 2);

        Text text = new Text("Willkommen!");
        text.setFont(Font.font("Verdana", FontPosture.ITALIC, 35 ));
        text.setStyle("-fx-font-weight: bold;");
        text.setFill(Color.BLACK);
        text.setEffect(blend);
        text.setCache(true);


        title.setAlignment(Pos.BOTTOM_CENTER);
        title.setPadding(new Insets(25,25,25,25));
        title.add(text, 0 , 6);

        stage.setScene(new Scene(border, 440, 350));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Test-Driven-Development-Trainer");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}