package com.example.calculatorfx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class FirstFx extends Application {
    Label label1;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextField txt;
    String inst = " input 2nd # \n result: ";
    int result;
    public static void main(String[] args) {
        launch(args);
    }

    public void calculate_result(ArrayList<String> equation, String type) {
        if(equation.isEmpty()) {
            equation.add(txt.getText());
            if(type.equals("+"))
                equation.add("+");
            if(type.equals("-"))
                equation.add("-");
            if(type.equals("*"))
                equation.add("*");
            if(type.equals("/"))
                equation.add("/");
            result = Integer.parseInt(txt.getText());
            label1.setText(inst + result);
            txt.clear();
        }
        else {
            if(equation.contains("+"))
                result = Integer.parseInt(equation.get(0)) + Integer.parseInt(txt.getText());
            if(equation.contains("-"))
                result = Integer.parseInt(equation.get(0)) - Integer.parseInt(txt.getText());
            if(equation.contains("*"))
                result = Integer.parseInt(equation.get(0)) * Integer.parseInt(txt.getText());
            if(equation.contains("/"))
                result = Integer.parseInt(equation.get(0)) / Integer.parseInt(txt.getText());
            equation.clear();
            equation.add(Integer.toString(result));
            equation.add("+");
            txt.clear();
            label1.setText(inst + result);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("calculator");
        label1 = new Label(" input # \n choose operation \n input 2nd # \n enter key to get result, clear to clear result");
        VBox root = new VBox();
        root.setSpacing(10);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        txt = new TextField();
        button1 = new Button("+");
        button2 = new Button("-");
        button3 = new Button("*");
        button4 = new Button("/");
        button5 = new Button("clear");
        ArrayList<String> equation = new ArrayList<>();
        txt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(equation.contains("+"))
                    result = Integer.parseInt(equation.get(0)) + Integer.parseInt(txt.getText());
                if(equation.contains("-"))
                    result = Integer.parseInt(equation.get(0)) - Integer.parseInt(txt.getText());
                if(equation.contains("*"))
                    result = Integer.parseInt(equation.get(0)) * Integer.parseInt(txt.getText());
                if(equation.contains("/"))
                    result = Integer.parseInt(equation.get(0)) / Integer.parseInt(txt.getText());
                label1.setText(" choose operation \n result: " + result);
                equation.clear();
                equation.add(Integer.toString(result));
                txt.setText(Integer.toString(result));
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate_result(equation, "+");
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate_result(equation, "-");
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate_result(equation, "*");
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate_result(equation, "/");
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                equation.clear();
                txt.clear();
                result = 0;
                label1.setText(" input # \n choose operation \n input 2nd # \n enter key to get result, clear to clear result");
            }
        });
        root.getChildren().addAll(txt, label1, button1, button2, button3, button4, button5);
        stage.show();
    }
}
