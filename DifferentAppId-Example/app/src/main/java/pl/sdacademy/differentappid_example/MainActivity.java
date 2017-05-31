package pl.sdacademy.differentappid_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.player_image);
    }

    @Override
        protected void onResume() {
        super.onResume();

        String playerImage = getString(R.string.app_speazzy);
        if (playerImage.contains("speazzy_logo")) {
            image.setImageResource(R.drawable.speazzy_logo);
        } else {
            image.setImageResource(R.drawable.speazzy_logo);
        }

        Log.d(TAG, String.format("Current package name is: [%s]", getApplicationContext().getPackageName()));
    }
}
