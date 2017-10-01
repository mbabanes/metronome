package sound;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Sound extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/menu.fxml"));
        Pane pane = loader.load();

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Metronom 4/4");
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception
    {
        launch(args);

    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
        System.exit(0);
    }
}
