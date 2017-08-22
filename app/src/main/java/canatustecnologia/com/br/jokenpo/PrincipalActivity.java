package canatustecnologia.com.br.jokenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void onClickButtonIrParaSobre(View view){
        Intent intentIrParaSobre = new Intent(this, SobreActivity.class);
        startActivity(intentIrParaSobre);
    }

    public void onClickButtonIrParaJogo(View view){
        Intent intentIrParaJogo = new Intent(this, JokenpoActivity.class);
        startActivity(intentIrParaJogo);

    }
}
