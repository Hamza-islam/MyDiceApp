package com.hamza.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myDiceRollBtn = (Button) findViewById(R.id.btn);
        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.dice_sound);
        final ImageView myMainImage = (ImageView) findViewById(R.id.firstImg);

        final int[] myDiceImagesInArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        final ImageView myDiceOne = (ImageView) findViewById(R.id.imageDice1);
        final ImageView myDiceTwo = (ImageView) findViewById(R.id.imageDice2);
//        rand.nextInt(6);
        myDiceRollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                myDiceOne.setImageResource(myDiceImagesInArray[rand.nextInt(6)]);

                myDiceTwo.setImageResource(myDiceImagesInArray[rand.nextInt(6)]);
                mPlayer.start();

                Toast.makeText(getApplicationContext(),"Dice has been rolled!",Toast.LENGTH_LONG).show();
                YoYo.with(Techniques.Shake)
                        .duration(900)
                        .repeat(0)
                        .playOn(myDiceOne);

                YoYo.with(Techniques.Shake)
                        .duration(900)
                        .repeat(0)
                        .playOn(myDiceTwo);
                YoYo.with(Techniques.RubberBand)
                        .duration(600)
                        .repeat(0)
                        .playOn(myMainImage);


            }
        });
    }
}