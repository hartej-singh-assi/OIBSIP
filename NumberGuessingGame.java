import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberGuessingGame extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private int randomNumber;
    private int numGuesses = 0;
    private int maxGuesses = 8;
    private int score = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Guess a number between 1 and 100:");
        TextField textField = new TextField();
        Button submit = new Button("Submit");
        Button hint = new Button("Hint");
        Label scoreLbl = new Label("Score: " + score);
        
        submit.setOnAction(event -> {
            int guess = Integer.parseInt(textField.getText());
            if (guess == randomNumber) {
                label.setText("You guessed the number in " + numGuesses + " attempts!\n" + "The number is " + randomNumber + "\n" + "Thank you for playing!");
                textField.setDisable(true);
                submit.setDisable(true);
                hint.setDisable(true);
                score++;
                scoreLbl.setText("Score: " + score);
            } else if (guess < randomNumber) {
                label.setText("Too low! Guess again:");
                numGuesses++;
                if (numGuesses >= maxGuesses) {
                    label.setText("You have reached the maximum number of guesses.\n" + "The number is " + randomNumber + "\n" + "Thank you for playing!");
                    textField.setDisable(true);
                    submit.setDisable(true);
                    hint.setDisable(true);
                }
            } else {
                label.setText("Too high! Guess again:");
                numGuesses++;
                if (numGuesses >= maxGuesses) {
                    label.setText("You have reached the maximum number of guesses.\n" + "The number is " + randomNumber + "\n" + "Thank you for playing!");
                    textField.setDisable(true);
                    submit.setDisable(true);
                    hint.setDisable(true);
                }
            }
        });

        hint.setOnAction(event -> {
            if (randomNumber % 2 == 0) {
                label.setText("Hint: The number is even.");
            } else {
                label.setText("Hint: The number is odd.");
            }
        });

        HBox hBox = new HBox(20, submit, hint, scoreLbl);
        hBox.setAlignment(Pos.CENTER);
         VBox vBox = new VBox(20, label, textField, submit, hint, scoreLbl);
         vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Guessing Game");
        primaryStage.show();
        randomNumber = new Random().nextInt(100) + 1;
    }
}
