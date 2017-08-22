package canatustecnologia.com.br.jokenpo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    private Random numeroAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);
        numeroAleatorio = new Random();
    }

    public void onClickButtonIrParaSobre(View view){
        Intent intentIrParaSobre = new Intent(this, SobreActivity.class);
        startActivity(intentIrParaSobre);
    }

    public void onClickButtonIrParaPrincipal(View view){
        Intent intentIrParaPrinciap = new Intent(this, PrincipalActivity.class);
        startActivity(intentIrParaPrinciap);
    }

    public void realizarJogadaComputador(int jogadaHumano){
        int jogadaPC = numeroAleatorio.nextInt(4);

        if(jogadaPC == 1){
            findViewById(R.id.imagem_view_computador).setBackgroundResource(R.drawable.pedra);
            if(jogadaHumano == 1){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.empatou);
            }else if(jogadaHumano == 2){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.venceu);
                playSound("ganhou");
            }else {
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.perdeu);
                playSound("perdeu");
            }
        }else if(jogadaPC == 2){
            findViewById(R.id.imagem_view_computador).setBackgroundResource(R.drawable.papel);
            if(jogadaHumano == 1){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.perdeu);
                playSound("perdeu");
            }else if(jogadaHumano == 2){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.empatou);
            }else {
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.venceu);
                playSound("ganhou");
            }
        }else{
            findViewById(R.id.imagem_view_computador).setBackgroundResource(R.drawable.tesoura);
            if(jogadaHumano == 1){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.venceu);
                playSound("ganhou");
            }else if(jogadaHumano == 2){
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.perdeu);
                playSound("perdeu");
            }else{
                findViewById(R.id.imagem_view_resultado).setBackgroundResource(R.drawable.empatou);
            }
        }
    }

    public void onClickPedra(View view){
        findViewById(R.id.imagem_view_jogador).setBackgroundResource(R.drawable.pedra);
        realizarJogadaComputador(1);
    }

    public void onClickPapel(View view){
        findViewById(R.id.imagem_view_jogador).setBackgroundResource(R.drawable.papel);
        realizarJogadaComputador(2);
    }

    public void onClickTesoura(View view){
        findViewById(R.id.imagem_view_jogador).setBackgroundResource(R.drawable.tesoura);
        realizarJogadaComputador(3);
    }

    private void playSound(String status){
        MediaPlayer mp = null;

        if(status.equals("ganhou")){
            mp = new MediaPlayer().create(this, R.raw.you_win);
        }else{
            mp = new MediaPlayer().create(this, R.raw.you_lose);
        }
        mp.start();
    }
}
