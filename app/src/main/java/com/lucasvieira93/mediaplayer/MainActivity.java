package com.lucasvieira93.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoTocar, botaoVoltar, botaoAvancar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoVoltar = findViewById(R.id.botaoVoltarId);
        botaoAvancar = findViewById(R.id.botaoAvancarId);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            Toast.makeText(this, "Obrigado por ouvir Razor!", Toast.LENGTH_SHORT).show();
            mediaPlayer.release();
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    private void tocarMusica(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            botaoTocar.setText("Pausar");
        }
    }

    private void pararMusica(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            botaoTocar.setText("Tocar");
        }
    }

    private void pausarMusica(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            botaoTocar.setText("Tocar");
        }
    }

    private void voltarMusica(){
    }

    private void avançarMusica(){
    }
}
