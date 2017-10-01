package sound.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sound.A2Tone;
import sound.MetronomeThreadNullObject;
import sound.MetronomeThread;

import javax.sound.midi.MidiUnavailableException;

public class Controller
{
    @FXML
    private TextField bmpTextField;

    @FXML
    private Button startButton;

    private MetronomeThread metronomeThread;


    public void initialize()
    {
        startButton.disableProperty().bind(bmpTextField.textProperty().isEmpty());
        metronomeThread = new MetronomeThreadNullObject();
    }

    public void buttonOnAction() throws Exception
    {
        if (!metronomeThread.alive())
        {
            long bmp = Long.valueOf(bmpTextField.getText());
            metronomeThread = new MetronomeThread(bmp);
            metronomeThread.start();

            startButton.setText("Stop");
        }
        else
        {
            metronomeThread.interrupt();
            startButton.setText("Start");
        }
    }



    public void playA2ToneOnAction( ) throws MidiUnavailableException
    {
        A2Tone a2Tone = new A2Tone();
        a2Tone.play();
    }
}
