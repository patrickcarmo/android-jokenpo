package canatustecnologia.com.br.jokenpo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }

    public void onClickButtonIrParaWikipedia(View view) {
        Uri uriSite = Uri.parse("https://pt.wikipedia.org/wiki/Pedra,_papel_e_tesoura");
        Intent intentSite = new Intent(Intent.ACTION_VIEW, uriSite);
        startActivity(intentSite);
    }

    public void onClickButtonLigarParaDesenvolvedor(View view) {
        Uri uriTelefone = Uri.parse("tel:+5562999371988");
        Intent intentTelefone = new Intent(Intent.ACTION_CALL, uriTelefone);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intentTelefone);
    }
}
