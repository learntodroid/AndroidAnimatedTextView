package com.learntodroid.animatedtext;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private TextView textView;
  private int number = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = findViewById(R.id.activity_main_animatedtextview);
    textView.setText(String.valueOf(number));

    textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int startNumber = number;
        int endNumber = number += 10;
        ValueAnimator vAnimator = ValueAnimator.ofInt(startNumber, endNumber);
        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
            textView.setText(valueAnimator.getAnimatedValue().toString());
          }
        });
        vAnimator.setDuration(1000);

        Integer startColor = Color.YELLOW;
        Integer endColor = Color.WHITE;
        ValueAnimator cAnimator = ValueAnimator.ofObject(
                new ArgbEvaluator(),
                startColor,
                endColor
        );
        cAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
            textView.setTextColor((Integer) valueAnimator.getAnimatedValue());
          }
        });
        cAnimator.setDuration(1000);

        vAnimator.start();
        cAnimator.start();
      }
    });
  }
}