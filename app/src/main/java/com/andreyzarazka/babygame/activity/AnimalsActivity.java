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

public class AnimalsActivity extends Activity {

    private ImageButton dogImageButton;
    private ImageButton pigImageButton;
    private ImageButton gooseImageButton;
    private ImageButton cowImageButton;
    private ImageButton goatImageButton;
    private ImageButton cockImageButton;
    private ImageButton catImageButton;
    private ImageButton horseImageButton;

    public SoundPool soundPool;

    private int dogSound;
    private int catSound;
    private int cockSound;
    private int goatSound;
    private int gooseSound;
    private int horseSound;
    private int kowSound;
    private int pigSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Полноэкраный режим
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_animals);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(attributes)
                    .build();
            dogSound = soundPool.load(this, R.raw.dog, 1);
            catSound = soundPool.load(this, R.raw.cat, 1);
            cockSound = soundPool.load(this, R.raw.cock, 1);
            goatSound = soundPool.load(this, R.raw.goat, 1);
            gooseSound = soundPool.load(this, R.raw.goose, 1);
            horseSound = soundPool.load(this, R.raw.horse, 1);
            kowSound = soundPool.load(this, R.raw.cow, 1);
            pigSound = soundPool.load(this, R.raw.pig, 1);

        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            dogSound = soundPool.load(this, R.raw.dog, 1);
            catSound = soundPool.load(this, R.raw.cat, 1);
            cockSound = soundPool.load(this, R.raw.cock, 1);
            goatSound = soundPool.load(this, R.raw.goat, 1);
            gooseSound = soundPool.load(this, R.raw.goose, 1);
            horseSound = soundPool.load(this, R.raw.horse, 1);
            kowSound = soundPool.load(this, R.raw.cow, 1);
            pigSound = soundPool.load(this, R.raw.pig, 1);
        }

        dogImageButton = (ImageButton) findViewById(R.id.dog_button);
        dogImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(dogSound);
            }
        });

        pigImageButton = (ImageButton) findViewById(R.id.pig_button);
        pigImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(pigSound);
            }
        });

        gooseImageButton = (ImageButton) findViewById(R.id.goose_button);
        gooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(gooseSound);
            }
        });

        cowImageButton = (ImageButton) findViewById(R.id.cow_button);
        cowImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(kowSound);
            }
        });

        goatImageButton = (ImageButton) findViewById(R.id.goat_button);
        goatImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(goatSound);
            }
        });

        cockImageButton = (ImageButton) findViewById(R.id.cock_button);
        cockImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(cockSound);
            }
        });

        catImageButton = (ImageButton) findViewById(R.id.cat_button);
        catImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(catSound);
            }
        });

        horseImageButton = (ImageButton) findViewById(R.id.horse_button);
        horseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(horseSound);
            }
        });
    }

    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
