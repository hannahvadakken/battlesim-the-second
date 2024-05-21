import java.io.File;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


public class Music {


    public static void sound(String s) {
        try {
            String file = s;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream(file));
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);


            SourceDataLine clip = (SourceDataLine) AudioSystem.getLine(info);
       
           
            clip.open(format);
            clip.start();


            byte[] buffer = new byte[4096];
            int bytesRead;


                // Read and play the audio data
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                clip.write(buffer, 0, bytesRead);
            }


            clip.drain();
            clip.close();
            //audioInputStream.close();
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void loop(String s) {


        Thread musicThread = new Thread(() -> {
            try {
                String file = s;
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream(file));
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
       
                SourceDataLine clip = (SourceDataLine) AudioSystem.getLine(info);
               
                int a = 0;
               
                clip.open(format);
                clip.start();
       
                byte[] buffer = new byte[4096];
                int bytesRead;


                while(a==0){
                    // Read and play the audio data
                    while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                        clip.write(buffer, 0, bytesRead);
                    }
                    audioInputStream = AudioSystem.getAudioInputStream(Music.class.getResourceAsStream(file));
                }


                clip.drain();
                clip.close();
                audioInputStream.close();
               
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        musicThread.start();
    }
}



