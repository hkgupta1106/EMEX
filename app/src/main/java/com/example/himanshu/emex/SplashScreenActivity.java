package com.example.himanshu.emex;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIMEOUT = 3000,REQUEST_CODE=1,RESULT_CODE=2;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Button btnLogin=(Button)findViewById(R.id.btn_Login);
        final Button btnSignup=(Button)findViewById(R.id.btn_Signup);
        btnLogin.setVisibility(View.GONE);
        btnSignup.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            btnLogin.setVisibility(View.VISIBLE);
                btnSignup.setVisibility(View.VISIBLE);
                Button btnLogin=(Button)findViewById(R.id.btn_Login);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SplashScreenActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                });

            }
        }, SPLASH_SCREEN_TIMEOUT);
    }

//    public void OnActivityResult(int requestCode,int resultCode,Intent intent)
//    {
//        if(RESULT_CODE == resultCode)
//        {
//           Intent intent1 = new Intent(SplashScreenActivity.this,SignupActivity.class);
//                startActivity(intent1);
//                finish();
//        }
//    }
}
