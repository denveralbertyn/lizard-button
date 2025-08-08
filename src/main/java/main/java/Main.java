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
        Image image = new Image("/img/liz_icon.png");
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        Media audioFile = new Media(getClass().getResource("/audio/audio.mp3").toExternalForm());



        button.setOnAction(actionEvent -> {
            MediaPlayer mediaPlayer = new MediaPlayer(audioFile);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(mediaPlayer::dispose);
        });

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        root.getChildren().add(button);

        stage.setScene(scene);
        stage.setTitle("LIZARD");
        stage.show();

    }
}