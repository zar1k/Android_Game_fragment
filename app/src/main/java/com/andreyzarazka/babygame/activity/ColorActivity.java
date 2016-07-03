package com.andreyzarazka.babygame.activity;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.andreyzarazka.babygame.R;

public class ColorActivity extends Activity {

    private ImageButton redImageButton;
    private ImageButton orangeImageButton;
    private ImageButton yellowImageButton;
    private ImageButton greenImageButton;
    private ImageButton blueImageButton;
    private ImageButton blue1ImageButton;
    private ImageButton purpleImageButton;
    private ImageButton blackImageButton;

    public SoundPool soundPool;

    private int redSound;
    private int orangeSound;
    private int yellowSound;
    private int greenSound;
    private int blueSound;
    private int blue1Sound;
    private int purpleSound;
    private int blackSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Полноэкраный режим
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_color);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(attributes)
                    .build();
            redSound = soundPool.load(this, R.raw.red, 1);
            orangeSound = soundPool.load(this, R.raw.orange, 1);
            yellowSound = soundPool.load(this, R.raw.yellow, 1);
            greenSound = soundPool.load(this, R.raw.green, 1);
            blueSound = soundPool.load(this, R.raw.blue, 1);
            blue1Sound = soundPool.load(this, R.raw.blue_one, 1);
            purpleSound = soundPool.load(this, R.raw.purple, 1);
            blackSound = soundPool.load(this, R.raw.black, 1);

        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            redSound = soundPool.load(this, R.raw.red, 1);
            orangeSound = soundPool.load(this, R.raw.orange, 1);
            yellowSound = soundPool.load(this, R.raw.yellow, 1);
            greenSound = soundPool.load(this, R.raw.green, 1);
            blueSound = soundPool.load(this, R.raw.blue, 1);
            blue1Sound = soundPool.load(this, R.raw.blue_one, 1);
            purpleSound = soundPool.load(this, R.raw.purple, 1);
            blackSound = soundPool.load(this, R.raw.black, 1);
        }

        redImageButton = (ImageButton) findViewById(R.id.red_button);
        redImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(redSound);
            }
        });

        orangeImageButton = (ImageButton) findViewById(R.id.orange_button);
        orangeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(orangeSound);
            }
        });

        yellowImageButton = (ImageButton) findViewById(R.id.yellow_button);
        yellowImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(yellowSound);
            }
        });

        greenImageButton = (ImageButton) findViewById(R.id.green_button);
        greenImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(greenSound);
            }
        });

        blueImageButton = (ImageButton) findViewById(R.id.blue_button);
        blueImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blueSound);
            }
        });

        blue1ImageButton = (ImageButton) findViewById(R.id.blue1_button);
        blue1ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blue1Sound);
            }
        });

        purpleImageButton = (ImageButton) findViewById(R.id.purple_button);
        purpleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(purpleSound);
            }
        });

        blackImageButton = (ImageButton) findViewById(R.id.black_button);
        blackImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blackSound);
            }
        });
    }

    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
