package main.java;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
            launch(args);
        }

    @Override
    public void start(Stage stage) {
        Button button = getButton();
        StackPane root = new StackPane();
        Scene scene = getScene(root);
        root.getChildren().add(button);
        setStage(stage, scene);
    }

    private Button getButton() {
        Image image = new Image(getClass().getResource("/img/liz_icon.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        Media audioFile = new Media(getClass().getResource("/audio/audio.mp3").toExternalForm());
        button.setId("btn");

        button.setOnAction(actionEvent -> {
            MediaPlayer mediaPlayer = new MediaPlayer(audioFile);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(mediaPlayer::dispose);
        });
        return button;
    }

    private Scene getScene(StackPane root) {
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/assets/style.css").toExternalForm());
        return scene;
    }

    private static void setStage(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("LIZARD");
        stage.show();
    }
}