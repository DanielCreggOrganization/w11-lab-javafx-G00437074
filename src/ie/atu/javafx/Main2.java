package ie.atu.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Title
        Label titleLabel = new Label("Registration");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        grid.add(titleLabel, 0, 0, 2, 1);

        // First Name
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameField, 1, 1);

        // Last Name
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameField, 1, 2);

        // Email
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        grid.add(emailLabel, 0, 3);
        grid.add(emailField, 1, 3);

        // Password
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        grid.add(passwordLabel, 0, 4);
        grid.add(passwordField, 1, 4);

        // Confirm Password
        Label confirmLabel = new Label("Confirm:");
        PasswordField confirmField = new PasswordField();
        grid.add(confirmLabel, 0, 5);
        grid.add(confirmField, 1, 5);

        // Register Button
        Button registerButton = new Button("Register");
        grid.add(registerButton, 1, 6);

        // Feedback Label
        Label feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-text-fill: red;");
        grid.add(feedbackLabel, 0, 7, 2, 1);

        // Register logic
        registerButton.setOnAction(e -> {
            String first = firstNameField.getText().trim();
            String last = lastNameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText();
            String confirm = confirmField.getText();

            if (first.isEmpty() || last.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                feedbackLabel.setText("All fields are required.");
            } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                feedbackLabel.setText("Invalid email address.");
            } else if (!password.equals(confirm)) {
                feedbackLabel.setText("Passwords do not match.");
            } else if (password.length() < 6) {
                feedbackLabel.setText("Password must be at least 6 characters.");
            } else {
                feedbackLabel.setStyle("-fx-text-fill: green;");
                feedbackLabel.setText("Registration successful!");
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}


