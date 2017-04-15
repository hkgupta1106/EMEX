package com.example.himanshu.emex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * forgot password activity
 */
public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ImageView imageView = (ImageView) findViewById(R.id.iv_back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });

        TextView tvCustomText = (TextView) findViewById(R.id.tv_custom_text);
        tvCustomText.setText("Forgot Password");
    }
}
