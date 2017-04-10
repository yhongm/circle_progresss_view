package com.yhongm.circle_progress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yhongm.circle_progress_core.CircleProgressView;

public class MainActivity extends AppCompatActivity {
    CircleProgressView circleProgressView;
    int progress = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgressView = (CircleProgressView) findViewById(R.id.circleprogress);
        circleProgressView.setCurrentProgress(progress);
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            if (progress < 100) {
                progress++;
                circleProgressView.setCurrentProgress(progress);
            } else {
                Toast.makeText(MainActivity.this, "值不能大于100", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_minus).setOnClickListener(v -> {
            if (progress > 0) {
                progress--;
                circleProgressView.setCurrentProgress(progress);
            } else {
                Toast.makeText(MainActivity.this, "值不能小于0", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
