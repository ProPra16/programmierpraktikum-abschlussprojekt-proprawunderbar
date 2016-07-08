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

        Button one = new Button("1");
        one.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        one.setEffect(blend);
        File OneExists = new File(a+"\\Aufgabenstellung\\1Aufgabenstellung.txt");
        if(!OneExists.exists()){
            one.setMouseTransparent(true);
            one.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        one.setOnAction(e -> {
            try {
                Test_UI.runTestUI("1");
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button two = new Button("2");
        two.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        two.setEffect(blend);
        File TwoExists = new File(a+"\\Aufgabenstellung\\2Aufgabenstellung.txt");
        if(!TwoExists.exists()){
            two.setMouseTransparent(true);
            two.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        two.setOnAction(e -> {
            try {
                Test_UI.runTestUI("2");
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button three = new Button("3");
        three.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        three.setEffect(blend);
        File ThreeExists = new File(a+"\\Aufgabenstellung\\3Aufgabenstellung.txt");
        if(!ThreeExists.exists()){
            three.setMouseTransparent(true);
            three.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        three.setOnAction(e -> {
            try {
                Test_UI.runTestUI("3");
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button four = new Button("4");
        four.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        four.setEffect(blend);
        File FourExists = new File(a+"\\Aufgabenstellung\\4Aufgabenstellung.txt");
        if(!FourExists.exists()){
            four.setMouseTransparent(true);
            four.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        four.setOnAction(e -> {
            try {
                Test_UI.runTestUI("4");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button five = new Button("5");
        five.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        five.setEffect(blend);
        File FiveExists = new File(a+"\\Aufgabenstellung\\5Aufgabenstellung.txt");
        if(!FiveExists.exists()){
            five.setMouseTransparent(true);
            five.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        five.setOnAction(e -> {
            try {
                Test_UI.runTestUI("5");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button six = new Button("6");
        six.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        six.setEffect(blend);
        File SixExists = new File(a+"\\Aufgabenstellung\\6Aufgabenstellung.txt");
        if(!SixExists.exists()){
            six.setMouseTransparent(true);
            six.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        six.setOnAction(e -> {
            try {
                Test_UI.runTestUI("6");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });
        Button seven = new Button("7");
        seven.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        seven.setEffect(blend);
        File SevenExists = new File(a+"\\Aufgabenstellung\\7Aufgabenstellung.txt");
        if(!SevenExists.exists()){
            seven.setMouseTransparent(true);
            seven.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        seven.setOnAction(e -> {
            try {
                Test_UI.runTestUI("7");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button eight = new Button("8");
        eight.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        eight.setEffect(blend);
        File EightExists = new File(a+"\\Aufgabenstellung\\8Aufgabenstellung.txt");
        if(!EightExists.exists()){
            eight.setMouseTransparent(true);
            eight.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        eight.setOnAction(e -> {
            try {
                Test_UI.runTestUI("8");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button nine = new Button("9");
        nine.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        nine.setEffect(blend);
        File NineExists = new File(a+"\\Aufgabenstellung\\9Aufgabenstellung.txt");
        if(!NineExists.exists()){
            nine.setMouseTransparent(true);
            nine.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        nine.setOnAction(e -> {
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

        root.add(one, 0, 0);
        root.add(two, 1, 0);
        root.add(three, 2, 0);
        root.add(four, 0, 1);
        root.add(five, 1, 1);
        root.add(six, 2, 1);
        root.add(seven, 0, 2);
        root.add(eight, 1, 2);
        root.add(nine, 2, 2);


        stage.setScene(new Scene(border, 350, 350));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Wähle deine Übung");
        stage.show();

    }
}
