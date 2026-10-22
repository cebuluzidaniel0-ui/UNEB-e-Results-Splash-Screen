package com.example.unebe_results;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3000;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler(Looper.getMainLooper());

        // Perform background check and transition after delay using lambda expression
        runnable = () -> {
            boolean isConnected = checkNetworkConnection();

            if (!isConnected) {
                Toast.makeText(splash.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }

            // Navigate to MainActivity
            Intent intent = new Intent(splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        };

        handler.postDelayed(runnable, SPLASH_DELAY);
    }

    // Helper method to verify network connectivity
    private boolean checkNetworkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clear handler callbacks to prevent memory leaks if the activity is destroyed
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}