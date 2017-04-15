package com.example.himanshu.emex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * sign up activity
 */
public class SignupActivity extends AppCompatActivity {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        ImageView imageView = (ImageView) findViewById(R.id.iv_back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });

        TextView tvCustomText = (TextView) findViewById(R.id.tv_custom_text);
        tvCustomText.setText("Signup");


        Button btnsignup = (Button) findViewById(R.id.btn_Signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


}