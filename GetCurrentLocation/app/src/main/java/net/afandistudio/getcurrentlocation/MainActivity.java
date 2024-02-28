package net.afandistudio.getcurrentlocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    private TextView latitude, longitude, altitude, akurasi;
    private Button btnFind;
    private FusedLocationProviderClient locationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        altitude = findViewById(R.id.altitude);
        akurasi = findViewById(R.id.akurasi);
        btnFind = findViewById(R.id.btn_find);

        locationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);

        btnFind.setOnClickListener(v -> {
            getLocation();
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10){
            if (ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "Izin lokasi tidak di aktifkan!", Toast.LENGTH_SHORT).show();
            }else{
                getLocation();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // get Permission
            requestPermissions(new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
            }, 10);
        }else {
            // get Location
            locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location!=null) {
                        latitude.setText(String.valueOf(location.getLatitude()));
                        longitude.setText(String.valueOf(location.getLongitude()));
                        altitude.setText(String.valueOf(location.getAltitude()));
                        akurasi.setText(location.getAccuracy() + "%");
                    }else{
                        Toast.makeText(getApplicationContext(), "Lokasi tidak aktif!", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}