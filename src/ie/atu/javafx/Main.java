package ie.atu.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Welcome message
        Label welcomeLabel = new Label("Welcome to the JavaFX App!");
        welcomeLabel.setFont(new Font("Arial", 24));

        // Current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss");
        Label dateTimeLabel = new Label("Current date and time: " + now.format(formatter));

        // Your name
        Label nameLabel = new Label("Created by: Adam Devlin"); // Replace [Your Name] with your actual name

        // Simple image (replace with your own path or URL)
        Image image = new Image("resources/cat.png"); // You can also use a URL like "https://example.com/image.png"
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        // Layout
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(welcomeLabel, dateTimeLabel, nameLabel, imageView);

        // Scene and stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Welcome Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
