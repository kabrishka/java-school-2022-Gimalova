package ru.croc.task19;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // установка надписи
        Text text = new Text("Hello, World!");
        text.setLayoutY(80);
        text.setLayoutX(80);

        Group group = new Group(text);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java Application");
        primaryStage.setWidth(250);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
}
