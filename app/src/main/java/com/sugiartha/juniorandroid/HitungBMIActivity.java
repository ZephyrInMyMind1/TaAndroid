package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class HitungBMIActivity extends AppCompatActivity {

    EditText txtBeratBadan, txtTinggibadan; //Deklarasi object bernama txtBeratBadan dan txtTinggiBadan yang merupakan EditText
    TextView txtStatusBadan; //Deklarasi object bernama txtStatusBadan yang merupakan TextView
    Button btnCekBMI; //Deklarasi object bernama btnCekBMI yang merupakan Button
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_bmi);

        txtBeratBadan = findViewById(R.id.txtBeratBadan); //Menyambungkan elemen dengan id txtBeratBadan yang ada di activity_main.xml kesini
        txtTinggibadan = findViewById(R.id.txtTinggiBadan); //Menyambungkan elemen dengan id txtTinggiBadan yang ada di activity_main.xml kesini
        txtStatusBadan = findViewById(R.id.txtStatusBadan); //Menyambungkan elemen dengan id txtStatusBadan yang ada di activity_main.xml kesini
        btnCekBMI = findViewById(R.id.btnCekBMI); //Menyambungkan elemen dengan id btnCekBMI yang ada di activity_main.xml kesini
        //btnCekBMI.setOnClickListener dibawah ini maksudnya adalah untuk me-listen (mengamati) btnCekBMI apakah ada click, apabila ada click, maka code didalamnya akan dieksekusi
        btnCekBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double beratBadan = Double.parseDouble(txtBeratBadan.getText().toString());
                double tinggiBadan = Double.parseDouble(txtTinggibadan.getText().toString());
                HitungBMI hitungBMI = new HitungBMI(beratBadan, tinggiBadan);
                double bmi = hitungBMI.getBMI();
                String kesimpulan ="BMI Anda adalah: " + df.format(bmi) +"\n" + hitungBMI.kesimpulanBMI(bmi);
                txtStatusBadan.setText(kesimpulan); //men-set tulisan yang ada di TextView sesuai dengan hasil dari perhitungan BMI (yaitu ada di string statusBadan)
            }
        });
    }
}
