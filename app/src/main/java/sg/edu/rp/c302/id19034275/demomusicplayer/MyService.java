package sg.edu.rp.c302.id19034275.demomusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;

public class MyService extends Service {
    // declaring object of MediaPlayer
    MediaPlayer player = new MediaPlayer();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "music.mp3");

//            if (!folder.exists()) {
//                folder.mkdir();
//            }
//
//            File file = new File(folder, "music.mp3");
//            if (!file.exists())
//                file.createNewFile();

            // specify the path of the audio file
            player.setDataSource(file.getPath());
            player.prepare();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // providing the boolean value as true to play the audio on loop
        player.setLooping(true);

        // starting the process
        player.start();

        // returns the status of the program
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // stopping the process
        player.stop();
    }
}