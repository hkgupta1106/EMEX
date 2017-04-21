package com.example.himanshu.emex;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fragment.MainJobFragment;
import fragment.MapFragment;

/**
 * home screen activity containing drawer
 */
public class HomeScreenActivity extends AppCompatActivity {

    private ImageView imageView, imageViewCall, imageViewMail;
    private DrawerLayout drawerLayout;
    private TextView tvJob, tvHome, tvNetwork, tvLogout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        imageView = (ImageView) findViewById(R.id.iv_back_button);
        imageView.setImageResource(R.drawable.ic_menu_button);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        imageViewCall = (ImageView) findViewById(R.id.iv_call);
        imageViewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                imageViewCall.setImageResource(R.drawable.icon_support_call_pressed);
            }
        });
        imageViewMail = (ImageView) findViewById(R.id.iv_mail);
        imageViewMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                imageViewMail.setImageResource(R.drawable.icon_support_msg_pressed);
            }
        });

        tvJob = (TextView) findViewById(R.id.tv_jobhistory);
        tvJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                tvHome = (TextView) findViewById(R.id.tv_home);
                tvHome.setVisibility(View.GONE);

                drawerLayout.closeDrawer(Gravity.START);

                MainJobFragment mainjobfragment = new MainJobFragment();

                FragmentManager fmjob = getSupportFragmentManager();
                FragmentTransaction ftjob = fmjob.beginTransaction();

                ftjob.replace(R.id.frame_Layout, mainjobfragment);
                ftjob.commit();


            }
        });

        tvNetwork = (TextView) findViewById(R.id.tv_networkview);
        tvNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                drawerLayout.closeDrawer(Gravity.START);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_Layout, new MapFragment());
                ft.commit();
            }
        });

        tvLogout = (TextView) findViewById(R.id.tv_logout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(HomeScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
