import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

public class App extends Application {
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Picture Who");

        // Top Panel
        Label pictureWhoLabel = new Label("PICTURE WHO?");
        pictureWhoLabel.setStyle("-fx-font-size: 33; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #5E4580");
        BorderPane.setAlignment(pictureWhoLabel, Pos.TOP_CENTER);

        imageView = new ImageView(new Image("file:img/Bone White Blue Groovy You Matter Desktop Wallpaper (1).png"));
        imageView.setFitWidth(600);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        VBox imageContainer = new VBox();
        imageContainer.getChildren().add(imageView);
        VBox.setMargin(imageView, new Insets(70, 0, 50, 390));

        BorderPane topPanel = new BorderPane();
        topPanel.setBackground(new Background(new BackgroundFill(Color.rgb(131, 101, 172), CornerRadii.EMPTY, Insets.EMPTY)));
        topPanel.setTop(pictureWhoLabel);
        topPanel.setCenter(imageContainer);

        // Play Button
        Button playButton = new Button("Play");
        playButton.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #5E4580; -fx-background-color: white;");
        playButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Starting");
            alert.setHeaderText(null);
            alert.setContentText("The game is starting...");
            alert.showAndWait();

            openGameWindow();
            primaryStage.hide();
        });

        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #5E4580; -fx-background-color: white;");
        exitButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to exit?");

            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");
            alert.getButtonTypes().setAll(yesButton, noButton);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == yesButton) {
                primaryStage.close();
            }
        });

        HBox buttonPanel = new HBox(20, playButton, exitButton);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(10));

        BorderPane mainPane = new BorderPane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(131, 101, 172), CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setCenter(topPanel);
        mainPane.setBottom(buttonPanel);

        Scene scene = new Scene(mainPane, 1000, 650);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void openGameWindow() {
        Stage gameStage = new Stage();
        gameStage.setTitle("Game Window");

        GridPane imagePanel = new GridPane();
        imagePanel.setPadding(new Insets(10));
        imagePanel.setAlignment(Pos.CENTER);
        imagePanel.setHgap(10);
        imagePanel.setVgap(10);

        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
            imageView.setStyle("-fx-border-color: black;");
            imagePanel.add(imageView, i % 2, i / 2);
        }

        HBox smallerPanel = new HBox(10);
        smallerPanel.setAlignment(Pos.CENTER);
        smallerPanel.setPadding(new Insets(10));

        for (int i = 0; i < 3; i++) {
            ImageView smallImageView = new ImageView();
            smallImageView.setFitWidth(100);
            smallImageView.setFitHeight(100);
            smallImageView.setPreserveRatio(true);
            smallImageView.setSmooth(true);
            smallImageView.setCache(true);
            smallImageView.setStyle("-fx-border-color: black;");
            smallerPanel.getChildren().add(smallImageView);
        }

        VBox mainPanel = new VBox(20, imagePanel, smallerPanel);
        mainPanel.setAlignment(Pos.CENTER);
        mainPanel.setBackground(new Background(new BackgroundFill(Color.rgb(131, 101, 172), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(mainPanel, 1000, 600);
        gameStage.setScene(scene);
        gameStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
