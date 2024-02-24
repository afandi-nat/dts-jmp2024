package net.afandistudio.bmiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editHeight, editWeight;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String heightStr = editHeight.getText().toString();
        String weightStr = editWeight.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            textResult.setText("Tinggi dan Berat Tidak Boleh Kosong");
            return;
        }

        float height = (Float.parseFloat(heightStr)/100);
        float weight = Float.parseFloat(weightStr);

        float bmi = weight / (height * height);

        String resultText = "Nilai BMI anda " + bmi + "\n";

        if (bmi < 18.5) {
            resultText += "Kurus";
        } else if (bmi < 24.9) {
            resultText += "Normal";
        } else if (bmi < 29.9) {
            resultText += "Gemuk";
        } else {
            resultText += "Obesitas";
        }

        textResult.setText(resultText);
    }
}