package com.grayhartcorp.quevengan;

import android.app.Activity;
import android.content.Intent;
import android.media.AsyncPlayer;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

public class SplashScreen extends Activity {
    ImageView im_gh, icon;
    FrameLayout fondo;
    //SoundPool sp;
    //AsyncPlayer mAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        im_gh = (ImageView) findViewById(R.id.spgh);
        icon = (ImageView)findViewById(R.id.iconas);
        fondo = (FrameLayout)findViewById(R.id.fondo);
        //fondo.setVisibility(View.INVISIBLE);
        icon.setVisibility(View.INVISIBLE);


       Thread myThread = new Thread() {
            @Override
            public void run() {
                Animation agr, ogr, fgr;
                agr = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.girar);
                agr.reset();
                ogr = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotar);
                ogr.reset();
                fgr = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fondo);
                fgr.reset();

                im_gh.startAnimation(agr);
                im_gh.setVisibility(View.INVISIBLE);
                fondo.setVisibility(View.VISIBLE);
                icon.setVisibility(View.VISIBLE);
                fondo.startAnimation(fgr);
                icon.startAnimation(ogr);
                //icon.setVisibility(View.INVISIBLE);


                /*mAsync = new AsyncPlayer(TAG);
                mAsync.play(getApplicationContext(),
                        Uri.parse("android.resource://" +getPackageName()+"/raw/sonido2"),
                        false,
                        AudioManager.STREAM_MUSIC);*/

                try {
                    sleep(7900);
                    Intent intent = new Intent(getApplicationContext(), Inicio.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}

