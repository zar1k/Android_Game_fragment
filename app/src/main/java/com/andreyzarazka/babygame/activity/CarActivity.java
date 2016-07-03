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

public class CarActivity extends Activity {

    private ImageButton bikeImageButton;
    private ImageButton busImageButton;
    private ImageButton carImageButton;
    private ImageButton airplaneImageButton;
    private ImageButton steamshipImageButton;
    private ImageButton trainImageButton;

    public SoundPool soundPool;

    private int bikeSound;
    private int busSound;
    private int carSound;
    private int airplaneSound;
    private int steamshipSound;
    private int trainSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Полноэкраный режим
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_car);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(attributes)
                    .build();
            bikeSound = soundPool.load(this, R.raw.bike, 1);
            busSound = soundPool.load(this, R.raw.bus, 1);
            carSound = soundPool.load(this, R.raw.car, 1);
            airplaneSound = soundPool.load(this, R.raw.airplane, 1);
            steamshipSound = soundPool.load(this, R.raw.steamship, 1);
            trainSound = soundPool.load(this, R.raw.train, 1);

        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            bikeSound = soundPool.load(this, R.raw.bike, 1);
            busSound = soundPool.load(this, R.raw.bus, 1);
            carSound = soundPool.load(this, R.raw.car, 1);
            airplaneSound = soundPool.load(this, R.raw.airplane, 1);
            steamshipSound = soundPool.load(this, R.raw.steamship, 1);
            trainSound = soundPool.load(this, R.raw.train, 1);
        }

        bikeImageButton = (ImageButton) findViewById(R.id.baik_button);
        bikeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(bikeSound);
            }
        });

        busImageButton = (ImageButton) findViewById(R.id.bus_button);
        busImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(busSound);
            }
        });

        carImageButton = (ImageButton) findViewById(R.id.car_button);
        carImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(carSound);
            }
        });

        trainImageButton = (ImageButton) findViewById(R.id.train_button);
        trainImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(trainSound);
            }
        });

        airplaneImageButton = (ImageButton) findViewById(R.id.plane_button);
        airplaneImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(airplaneSound);
            }
        });

        steamshipImageButton = (ImageButton) findViewById(R.id.ship_button);
        steamshipImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(steamshipSound);
            }
        });
    }

    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
