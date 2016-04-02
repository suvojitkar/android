package com.androidbelieve.drawerwithswipetabs.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.androidbelieve.drawerwithswipetabs.MainActivity;
import com.androidbelieve.drawerwithswipetabs.R;

public class Splash extends Activity {

  private AnimatedCircleLoadingView animatedCircleLoadingView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
    startLoading();
    startPercentMockThread();
  }

  private void startLoading() {
    animatedCircleLoadingView.startDeterminate();
  }

  private void startPercentMockThread() {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(800);
          for (int i = 0; i <= 100; i++) {
            Thread.sleep(30);
            changePercent(i);
          }
          SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

          //getSharedPref from Boolean loggedin
          boolean l = pref.getBoolean("loggedin",false);

          Intent intent;
          if(l == false)
          intent = new Intent(Splash.this,Login.class);

          else
          intent = new Intent(Splash.this,MainActivity.class);

          startActivity(intent);

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    new Thread(runnable).start();
  }

  private void changePercent(final int percent) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        animatedCircleLoadingView.setPercent(percent);
      }
    });
  }

  public void resetLoading() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        animatedCircleLoadingView.resetLoading();
      }
    });
  }

  @Override
  protected void onPause() {
    super.onPause();
    finish();
  }
}