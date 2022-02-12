package com.example.proj2wangbogatyrevdimitrov;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.*;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.control.TextInputDialog;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("try.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        //scene.getStylesheets().add("hello.css");



        //Button button = (Button) scene.lookup("#hello");
        //button.setText("bla");



        stage.setScene(scene);

        stage.show();
        Button hello = (Button) scene.lookup("#hello");
        hello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Give me a number");
                dialog.setHeaderText("Give me an integer from 0 to 255:");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(number -> {hello.setText(number);});
            }
        });

        Button goodbye = (Button) scene.lookup("#goodbye");

        TextField textfield = (TextField) scene.lookup("#textfield");


        MenuBar menubar = (MenuBar) scene.lookup("#menubar");

        Menu menu = (Menu) menubar.getMenus().get(0);

        MenuItem reset = (MenuItem) menu.getItems().get(0);

        reset.setText("khuy");


    }

    public static void main(String[] args) {
        launch();
    }
}