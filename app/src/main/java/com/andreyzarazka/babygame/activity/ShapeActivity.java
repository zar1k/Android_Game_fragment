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

public class ShapeActivity extends Activity {

    private ImageButton ellipseImageButton;
    private ImageButton rectangleImageButton;
    private ImageButton triangleImageButton;
    private ImageButton squareImageButton;
    private ImageButton rhombusImageButton;
    private ImageButton circleImageButton;

    public SoundPool soundPool;

    private int ellipseSound;
    private int rectangleSound;
    private int triangleSound;
    private int squareSound;
    private int rhombusSound;
    private int circleSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Полноэкраный режим
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_shape);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(attributes)
                    .build();
            ellipseSound = soundPool.load(this, R.raw.ellipse, 1);
            rectangleSound = soundPool.load(this, R.raw.rectangle, 1);
            triangleSound = soundPool.load(this, R.raw.triangle, 1);
            squareSound = soundPool.load(this, R.raw.square, 1);
            rhombusSound = soundPool.load(this, R.raw.rhombus, 1);
            circleSound = soundPool.load(this, R.raw.circle, 1);

        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            ellipseSound = soundPool.load(this, R.raw.ellipse, 1);
            rectangleSound = soundPool.load(this, R.raw.rectangle, 1);
            triangleSound = soundPool.load(this, R.raw.triangle, 1);
            squareSound = soundPool.load(this, R.raw.square, 1);
            rhombusSound = soundPool.load(this, R.raw.rhombus, 1);
            circleSound = soundPool.load(this, R.raw.circle, 1);
        }

        ellipseImageButton = (ImageButton) findViewById(R.id.ellipse_button);
        ellipseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(ellipseSound);
            }
        });

        rectangleImageButton = (ImageButton) findViewById(R.id.rectangle_button);
        rectangleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(rectangleSound);
            }
        });

        triangleImageButton = (ImageButton) findViewById(R.id.triangle_button);
        triangleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(triangleSound);
            }
        });

        squareImageButton = (ImageButton) findViewById(R.id.square_button);
        squareImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(squareSound);
            }
        });

        rhombusImageButton = (ImageButton) findViewById(R.id.rhombus_button);
        rhombusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(rhombusSound);
            }
        });

        circleImageButton = (ImageButton) findViewById(R.id.circle_button);
        circleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(circleSound);
            }
        });
    }

    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
