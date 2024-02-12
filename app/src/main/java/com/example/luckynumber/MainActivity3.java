package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    TextView text;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text = findViewById(R.id.text);
        btn1 = findViewById(R.id.btn1);

        Intent i = getIntent();
        String UserName = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        text.setText(" "+ random_num);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareData(UserName, random_num);
            }
        });

    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 100;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String username , int randomNum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, username + "Got Lucky Number");
        i.putExtra(Intent.EXTRA_TEXT, "Hi Lucky Number is : "+randomNum);

        startActivity(Intent.createChooser(i, "Choose a Platform "));
    }
}