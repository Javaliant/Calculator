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
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Calculator extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		TextField[] inputs = new TextField[2];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new TextField();
			inputs[i].setPromptText("Enter operand here");
		}

		ComboBox<Operation> operations = new ComboBox<>();
		operations.getItems().addAll(Operation.values());
		operations.setValue(Operation.values()[0]);

		Label result = new Label("Result will go here");
		Button calculate = new Button("Calculate");
		calculate.setOnAction(
			e -> result.setText(
				computeResult(
					operations.getValue(),
					inputs[0].getText(),
					inputs[1].getText()
				)
			)
		);
		calculate.setDefaultButton(true);

		HBox layout = new HBox();
		layout.getChildren()
			.addAll(inputs[0], operations, inputs[1], calculate, result);

		Scene scene = new Scene(layout);
		scene.getStylesheets().add("Assets/Calculator.css");

		stage.setScene(scene);
		stage.getIcons().add(new Image(
			getClass().getResourceAsStream("Assets/Icon.png")));
		stage.show();
	}

	private static String computeResult(Operation op, String i1, String i2) {
		double alpha;
		double beta;

		try {
			alpha = Double.parseDouble(i1);
			beta = Double.parseDouble(i2);
		} catch (NumberFormatException nfe) {
			return "Invalid input";
		}

		if (beta == 0 && (op == Operation.DIVIDE || op == Operation.MOD)) {
			return "Cannot divide by 0";
		}

		double result = op.compute(alpha, beta);

		return result == (int)result ? 
			Integer.toString((int)result) : String.format("%.2f", result);	
	}
}