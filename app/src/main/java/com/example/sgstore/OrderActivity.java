package com.example.sgstore;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class OrderActivity extends AppCompatActivity {

    TextView textView;
    String message, name, id;
    SharedPreferences iDpref;
    SharedPreferences.Editor editor;
    EditText editTextid, editTextname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        //يظبط الدنيا لو الانترنت مش شغال
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editTextid = findViewById(R.id.editTextID);
        editTextname = findViewById(R.id.editTextName);
        textView = findViewById(R.id.textView3);
        Intent intent = getIntent();
        String order = intent.getStringExtra("order");
        textView.setText(textView.getText() + order);
        editTextid = findViewById(R.id.editTextID);
        iDpref = getSharedPreferences("idFile", MODE_PRIVATE);
        editTextid.setText(iDpref.getString("id", ""));

    }

    public void onClickRadioButton(View view) {
        editTextname = findViewById(R.id.editTextName);

        name = editTextname.getText().toString();
        id = editTextid.getText().toString();
        editor = iDpref.edit();
        editor.putString("id", id);
        editor.apply();
        message = textView.getText().toString() + "\n Name " + name + "\n ID: " + id;
        Button button = findViewById(R.id.button4);
        if (id.length() != 10 || name.isEmpty() == true) {
            Toast.makeText(this, "ادخلت بيانات خاطئة او غير مكتملة", Toast.LENGTH_SHORT).show();
        } else {
            if (view.getId() == R.id.radioButton) {
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phoneNumberWithCountryCode = "+201144657861";
                        Intent openWhatsap = new Intent(Intent.ACTION_VIEW);
                        openWhatsap.putExtra(Intent.EXTRA_TEXT, message);
                        openWhatsap.setData(Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumberWithCountryCode, message)));
                        startActivity(openWhatsap);
                    }
                });
            } else {
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phoneNumberWithCountryCode = "+201128922088";
                        Intent openWhatsap = new Intent(Intent.ACTION_VIEW);
                        openWhatsap.setData(Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumberWithCountryCode, message)));
                        startActivity(openWhatsap);
                    }
                });
            }
        }

    }


}