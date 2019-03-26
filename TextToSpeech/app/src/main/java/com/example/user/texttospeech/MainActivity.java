package com.example.user.texttospeech;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    private TextToSpeech mtts;
    private EditText meditText;
    private SeekBar mseekbarpitch;
    private SeekBar mseekbarspeed;
    private Button mbuttonspeak;

    //for background
    LinearLayout myLayout;
    AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting background
        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        mbuttonspeak = findViewById(R.id.button_speak);

        mtts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                //ekhane text ta tik moto support kortese kina seta check kortese

                if(i == TextToSpeech.SUCCESS){
                    int result = mtts.setLanguage(Locale.US);

                //jodi text support kore tahole button ta o enable kore dibe & support na korle sms dibe j possible na

                    if(result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED){
//                        Log.e("TTS", "Language is not Supported");
                        Toast.makeText(MainActivity.this, "Not Supported", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        mbuttonspeak.setEnabled(true);
                    }
                }

                else {

//                    Log.e("TTS", "Initialization failed");
                    Toast.makeText(MainActivity.this, "Initialization Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        meditText = findViewById(R.id.edit_text);
        mseekbarpitch = findViewById(R.id.seekbar_pitch);
        mseekbarspeed = findViewById(R.id.seekbar_speed);

        mbuttonspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
    }
    private void speak(){
        String text = meditText.getText().toString();
        //for pitch
        float pitch = (float) mseekbarpitch.getProgress()/50;
        if(pitch<0.1)pitch = 0.1f;
        //for speed
        float speed = (float) mseekbarspeed.getProgress()/50;
        if(speed<0.1)speed = 0.1f;

        mtts.setPitch(pitch);
        mtts.setSpeechRate(speed);

        mtts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if(mtts!=null){
            mtts.stop();
            mtts.shutdown();
        }
        super.onDestroy();
    }
}
