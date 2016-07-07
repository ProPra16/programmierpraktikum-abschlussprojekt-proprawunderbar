package tddt.code;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.UI.Test_UI;
import tddt.UI.Test_UI;

import java.io.File;
import java.io.IOException;


public class Loader{
    public static void ask() throws Exception {
        Stage stage = new Stage();
        BorderPane border = new BorderPane();
        GridPane root = new GridPane();
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

        String a=  System.getProperty("user.dir");

        Button One = new Button("1");
        One.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        One.setEffect(blend);
        File OneExists = new File(a+"\\Aufgabenstellung\\1Aufgabenstellung.txt");
        if(!OneExists.exists()){
            One.setMouseTransparent(true);
            One.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        One.setOnAction(e -> {
            try {
                Test_UI.runTestUI("1");
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button Two = new Button("2");
        Two.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Two.setEffect(blend);
        Two.setOnAction(e -> {
            try {
                Test_UI.runTestUI("2");
            } catch (IOException e1) {}
            stage.close();
        });

        Button Three = new Button("3");
        Three.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Three.setEffect(blend);
        Three.setOnAction(e -> {
            try {
                Test_UI.runTestUI("3");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });
        Button Four = new Button("4");
        Four.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Four.setEffect(blend);
        Four.setOnAction(e -> {
            try {
                Test_UI.runTestUI("4");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button Five = new Button("5");
        Five.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Five.setEffect(blend);
        Five.setOnAction(e -> {
            try {
                Test_UI.runTestUI("5");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button Six = new Button("6");
        Six.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Six.setEffect(blend);
        Six.setOnAction(e -> {
            try {
                Test_UI.runTestUI("6");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });
        Button Seven = new Button("7");
        Seven.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Seven.setEffect(blend);
        Seven.setOnAction(e -> {
            try {
                Test_UI.runTestUI("7");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button Eight = new Button("8");
        Eight.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Eight.setEffect(blend);
        Eight.setOnAction(e -> {
            try {
                Test_UI.runTestUI("8");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button Nine = new Button("9");
        Nine.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        Nine.setEffect(blend);
        Nine.setOnAction(e -> {
            try {
                Test_UI.runTestUI("9");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });


        border.setCenter(root);
        border.setStyle("-fx-background-color: #E0E0E0");

        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(75,75,75,75));

        root.add(One, 0, 0);
        root.add(Two, 1, 0);
        root.add(Three, 2, 0);
        root.add(Four, 0, 1);
        root.add(Five, 1, 1);
        root.add(Six, 2, 1);
        root.add(Seven, 0, 2);
        root.add(Eight, 1, 2);
        root.add(Nine, 2, 2);


        stage.setScene(new Scene(border, 350, 350));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Wähle deine Übung");
        stage.show();

    }
}
