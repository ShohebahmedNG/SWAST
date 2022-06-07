package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout hosbtn,fuelbtn,smarthealthbtn,aboutbtn,profilebtn,sensorbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        hosbtn = (LinearLayout) findViewById(R.id.hospital_button);
        hosbtn.setAnimation(animation1);
        hosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hosbtn.startAnimation(animation1);
                clicked_btn("https://www.google.com/maps/search/hospital");
            }
        });
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        fuelbtn = (LinearLayout) findViewById(R.id.fuelstation_button);
        fuelbtn.setAnimation(animation2);
        fuelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fuelbtn.startAnimation(animation2);
                clicked_btn("https://www.google.com/maps/search/petrol+station");
            }
        });
        final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        smarthealthbtn = (LinearLayout) findViewById(R.id.health_button);
        smarthealthbtn.setAnimation(animation3);
        smarthealthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smarthealthbtn.startAnimation(animation3);
                Intent intent = new Intent(MainActivity.this,SmartHealth.class);
                MainActivity.this.startActivity(intent);
            }
        });
        aboutbtn = (LinearLayout) findViewById(R.id.about_button);

        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        profilebtn = (LinearLayout) findViewById(R.id.profile_button);
        profilebtn.setAnimation(animation4);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fuelbtn.startAnimation(animation4);
                Intent intent = new Intent(MainActivity.this,Profile.class);
                MainActivity.this.startActivity(intent);
            }
        });
        final Animation animation5 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        sensorbtn = (LinearLayout) findViewById(R.id.sensor_button);
        sensorbtn.setAnimation(animation5);
        sensorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sensorbtn.startAnimation(animation5);
                Intent local_strg = new Intent();
                local_strg.setAction(Intent.ACTION_VIEW);
                local_strg.setClassName("com.example.online_database","com.example.online_database.MainActivity");
                startActivity(local_strg);
            }
        });
    }
    public void clicked_btn(String url)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}