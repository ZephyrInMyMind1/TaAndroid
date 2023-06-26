package com.sugiartha.juniorandroid;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class GPS extends AppCompatActivity {
    private FusedLocationProviderClient client;

    @SuppressLint("MissingPermission")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        // Inisialisasi tombol getLocation
        Button button = findViewById(R.id.getLocation);

        // Tambahkan kode berikut setelah inisialisasi tombol getLocation
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(GPS.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // Jika izin tidak diberikan, tampilkan pesan atau minta izin kembali
                    Toast.makeText(GPS.this, "Izin akses lokasi belum diberikan", Toast.LENGTH_SHORT).show();
                    return;
                }

                client.getLastLocation().addOnSuccessListener(GPS.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            // Mendapatkan lokasi berhasil
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();

                            // Tampilkan atau gunakan lokasi sesuai kebutuhan Anda
                            TextView textView = findViewById(R.id.location);
                            textView.setText("Lat: " + latitude + ", Long: " + longitude);

                            Log.d("My Current location", "Lat: " + latitude + ", Long: " + longitude);
                            Toast.makeText(GPS.this, "Lokasi ditemukan\nLat: " + latitude + ", Long: " + longitude, Toast.LENGTH_LONG).show();
                        } else {
                            // Tidak ada lokasi terakhir yang tersedia
                            Toast.makeText(GPS.this, "Tidak dapat mendapatkan lokasi terakhir", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // Panggil metode requestPermissions()
        requestPermissions(new String[]{ACCESS_FINE_LOCATION}, 1);

        client = LocationServices.getFusedLocationProviderClient(this);

        // GET CURRENT LOCATION
        FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    // Do it all with location
                    Log.d("My Current location", "Lat : " + location.getLatitude() + " Long : " + location.getLongitude());
                    // Display in Toast
                    Toast.makeText(GPS.this,
                            "Lat : " + location.getLatitude() + " Long : " + location.getLongitude(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}