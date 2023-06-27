package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;
import java.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LingkaranActivity extends AppCompatActivity {

    Button bersihkan, luas, keliling;
    EditText jari2;
    TextView nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        DecimalFormat df = new DecimalFormat("#.##");
        bersihkan = (Button) findViewById(R.id.bersihkan);
        jari2 = (EditText) findViewById(R.id.jari2);
        nilai = (TextView) findViewById(R.id.nilai);
        luas = (Button) findViewById(R.id.luas);
        keliling = (Button) findViewById(R.id.keliling);

        bersihkan.setOnClickListener(new Button.OnClickListener() {
            @Override public void onClick(View v) {
                nilai.setText(" ");
            }});
        luas.setOnClickListener(new Button.OnClickListener() {
            @Override public void onClick(View v) {
                double jari = Double.parseDouble(jari2.getText().toString());
                double phi = 3.14;
                double luas = phi*jari*jari;
                nilai.setText("Luas Lingkaran : " + df.format(luas));
            }});

        keliling.setOnClickListener(new View.OnClickListener(){
            @Override public  void onClick(View v){
                double jari = Double.parseDouble(jari2.getText().toString());
                double phi = 3.14;
                double keliling = 2*phi*jari;
                nilai.setText("Keliling Lingkaran : " + df.format(keliling));
            }
        });
    }
}
