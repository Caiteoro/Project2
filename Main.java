package proj2WangBogatyrevDimitrov;

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

import javax.swing.*;

/*
 * File: Main.java
 * Names: Philipp Bogatyrev, Anton Dimitrov, Baron Wang
 * Class: CS 361
 * Project 2
 * Date: February 14
 */

/**
 * The Main class for project 2 application.
 *
 * Creates a window with a menu "file" that contains two menu items: reset
 * and exit. The reset menu item resets everything in the window, and the exit menu item
 * immediately force the program to exit upon clicking.
 *
 * Two buttons are laid out in the tool bar: Hello and Goodbye. Hello creates a text input
 * dialogue when clicked, prompting the user to input any number between 0 - 255. Goodbye
 * appends the text "Goodbye" in the text area that follows.
 *
 * The text area can change its size to fit the window.
 *
 * @author Philipp Bogatyrev, Anton Dimitrov, Baron Wang
 */
public class Main extends Application {

    /** Configures the hello button by letting it set the text in the button itself
     * @author Philipp Bogatyrev, Anton Dimitrov
     * @param scene scene for primary stage
     */
	public void configureHelloButton(Scene scene){
		Button hello = (Button) scene.lookup("#hello");
        hello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Give me a number");
                dialog.setHeaderText("Give me an integer from 0 to 255:");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(num -> {hello.setText(num);});
            }
        });
	}

    /** Configures the goodbye button by appending the word "goodbye" in the text area below
     * @author Philipp Bogatyrev, Anton Dimitrov
     * @param scene scene for primary stage
     */
	public void configureGoodbyeButton(Scene scene){
		Button goodbye = (Button) scene.lookup("#goodbye");
		TextArea textArea = (TextArea) scene.lookup("#textarea");
		goodbye.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                textArea.appendText("Goodbye");
            }
        });	
	}

    /** Configures the menu bar by adding the reset and exit memu options
     * @author Philipp Bogatyrev, Anton Dimitrov, Baron Wang
     * @param scene scene for primary stage
     */
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
		
		MenuItem exit = (MenuItem) menu.getItems().get(2); // menu.getItems().get(1) will return the separator
		exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

	}

    /**
     * The start method that sets up the program.
     * @author Anton Dimitrov, Philipp Bogatyrev
     * @param stage the primary stage
     * @throws IOException
     */
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

    /**
     * The main method that launches the application
     * @author Anton Dimitrov, Philipp Bogatyrev
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}