package com.example.eventa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Splashscreen extends Activity {

    private static int SPLASH_TIME_OUT=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent mainIntent=new Intent(Splashscreen.this,Login.class);
                startActivity(mainIntent);
                finish();

            }
        },SPLASH_TIME_OUT);

}
}