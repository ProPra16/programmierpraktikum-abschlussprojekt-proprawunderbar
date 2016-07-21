package tddt.code;


import java.io.IOException;
import java.util.List;

import exercises.Exercise;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tddt.UI.Test_UI;


public class Loader{
	static List<Exercise> exerciseList;
    public static void ask(List<Exercise> exercises) throws Exception {
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

        CheckBox Baby = new CheckBox();
        Baby.setText("BabySteps aktivieren");
        Baby.setSelected(true);

        Slider slider = new Slider(60, 300, 60);

        Label label = new Label(String.format("Zeit: %d",
                (int) slider.getValue()));

        slider.valueProperty().addListener(
                (ov, oldValue, newValue) -> {
                    int value = newValue.intValue();
                    label.setText(String.format("Zeit: %d", value));
                }
        );

        Button one = new Button("1");
        one.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        one.setEffect(blend);
        exerciseList = exercises;

        if(exercises.size()<1){
            one.setMouseTransparent(true);
            one.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }


        one.setOnAction(e -> {
            try {
                Exercise eins = exerciseList.get(0);
                eins.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                     eins.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(0) );

            } catch (IOException e1) {
            }

            stage.close();
        });

        Button two = new Button("2");
        two.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        two.setEffect(blend);
        if(exercises.size()<2){
            two.setMouseTransparent(true);
            two.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        two.setOnAction(e -> {
            try {
                Exercise zwei = exerciseList.get(1);
                zwei.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    zwei.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(1) );
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button three = new Button("3");
        three.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        three.setEffect(blend);
        if(exercises.size()<3){
            three.setMouseTransparent(true);
            three.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        three.setOnAction(e -> {
            try {
                Exercise drei = exerciseList.get(2);
                drei.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    drei.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(2) );
            } catch (IOException e1) {
            }
            stage.close();
        });

        Button four = new Button("4");
        four.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        four.setEffect(blend);
        if(exercises.size()<4){
            four.setMouseTransparent(true);
            four.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        four.setOnAction(e -> {
            try {
                Exercise vier = exerciseList.get(3);
                vier.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    vier.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(3) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button five = new Button("5");
        five.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        five.setEffect(blend);
        if(exercises.size()<5){
            five.setMouseTransparent(true);
            five.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        five.setOnAction(e -> {
            try {
                Exercise fuenf = exerciseList.get(4);
                fuenf.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    fuenf.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(4) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button six = new Button("6");
        six.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        six.setEffect(blend);
        if(exercises.size()<6){
            six.setMouseTransparent(true);
            six.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        six.setOnAction(e -> {
            try {
                Exercise sechs = exerciseList.get(5);
                sechs.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    sechs.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(5) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });
        Button seven = new Button("7");
        seven.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        seven.setEffect(blend);
        if(exercises.size()<7){
            seven.setMouseTransparent(true);
            seven.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        seven.setOnAction(e -> {
            try {
                Exercise sieben = exerciseList.get(6);
                sieben.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    sieben.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(6) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button eight = new Button("8");
        eight.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        eight.setEffect(blend);
        if(exercises.size()<8){
            eight.setMouseTransparent(true);
            eight.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        eight.setOnAction(e -> {
            try {
                Exercise acht = exerciseList.get(7);
                acht.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    acht.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(7) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        Button nine = new Button("9");
        nine.setStyle("-fx-font: 25 georgia;-fx-font-weight: bold; -fx-base: #FFFFFF");
        nine.setEffect(blend);
        if(exercises.size()<9){
            nine.setMouseTransparent(true);
            nine.setStyle("-fx-font: 25 georgia; -fx-text-fill: #000000; -fx-font-weight: bold; -fx-base: #985656");
        }
        nine.setOnAction(e -> {
            try {
                Exercise neun = exerciseList.get(8);
                neun.babystep = Baby.isSelected();
                if (Baby.isSelected()) {
                    neun.time = (int) slider.getValue();
                }
                Test_UI.runTestUI(Loader.exerciseList.get(8) );
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
        root.add(Baby, 0, 3);
        root.add(slider, 1, 3);
        root.add(label, 2, 3);


        stage.setScene(new Scene(border, 350, 350));
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Wähle deine Übung");
        stage.show();

    }
}
