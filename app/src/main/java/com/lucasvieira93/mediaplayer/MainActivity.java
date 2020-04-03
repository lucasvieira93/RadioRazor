package com.lucasvieira93.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = findViewById(R.id.botaoTocarId);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.razor);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });
    }

    private void tocarMusica(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            botaoTocar.setText("Pausar");
        }

    }

    private void pausarMusica(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            botaoTocar.setText("Tocar");
        }
    }
}
