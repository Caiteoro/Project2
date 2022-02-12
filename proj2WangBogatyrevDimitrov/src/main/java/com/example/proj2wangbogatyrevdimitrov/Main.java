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



public class Main extends Application {
	
	public void configureHelloButton(Scene scene){
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
	}
	
	public void configureGoodbyeButton(Scene scene){
		Button goodbye = (Button) scene.lookup("#goodbye");
	}
	
	public void configureMenuBar(Scene scene){
		
		Button hello = (Button) scene.lookup("#hello");
        TextArea textArea = (TextArea) scene.lookup("#textarea");
		MenuBar menubar = (MenuBar) scene.lookup("#menubar");
		Menu menu = (Menu) menubar.getMenus().get(0);
		
        MenuItem reset = (MenuItem) menu.getItems().get(0);	
		reset.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                textArea.setText("Sample text");
                hello.setText("Hello");
            }
        });	
		
		MenuItem exit = (MenuItem) menu.getItems().get(1);
		exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });	
	}
	
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Anton, Baron, and Philipp's Project 2");
        stage.setScene(scene);
        stage.show();
        
		configureHelloButton(scene);
		configureGoodbyeButton(scene);
        configureMenuBar(scene);
    }
    public static void main(String[] args) {
        launch();
    }
}