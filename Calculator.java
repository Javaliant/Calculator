/* Author: Luigi Vincent
Simple Calculator app
Performs an operation on two numbers and displays the result.

Created to practice Java 8 lambdas, JavaFX, and CSS.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Calculator extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		Label result = new Label("Result will go here");

		stage.setScene(new Scene(result));
		stage.show();
	}
}