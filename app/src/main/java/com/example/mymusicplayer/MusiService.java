package com.example.mymusicplayer;

        import android.app.Service;
        import android.content.Intent;
        import android.content.ServiceConnection;
        import android.media.MediaPlayer;
        import android.os.Binder;
        import android.os.IBinder;
        import android.util.Log;
        import android.view.View;

public class MusiService extends Service{
    public static MediaPlayer mp;
    //@Override
    public void onCreate(){
        super.onCreate();
        mp=MainActivity.mp;
        Log.d(getClass().getName(),"Service created.");
    }
    public IBinder onBind(Intent intent){
        return null;
    }
    public void onStart(Intent intent,int startId){
        super.onStart(intent,startId);
        playMusic();
        Log.d(getClass().getName(),"Start play music");
    }

    //@Override
    public void  onDestroy(){
        super.onDestroy();
        this.stopMusic();
    }

    private void stopMusic() {
        mp.stop();
    }
    public void playMusic(){
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }
    }
}
