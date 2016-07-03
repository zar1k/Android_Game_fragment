package com.andreyzarazka.babygame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.andreyzarazka.babygame.R;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizLogLevel;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Реклама
        AdBuddiz.setTestModeActive();
        AdBuddiz.setLogLevel(AdBuddizLogLevel.Info);
        AdBuddiz.setPublisherKey("TEST_PUBLISHER_KEY");
        AdBuddiz.cacheAds(this);
        AdBuddiz.isReadyToShowAd(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    int logoTimer = 0;
                    while (logoTimer < 3000) {
                        sleep(100);
                        logoTimer = logoTimer + 100;
                    }
                    startActivity(new Intent("com.andreyzarazka.babygame.GAMESCREEN"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        logoTimer.start();
    }
}