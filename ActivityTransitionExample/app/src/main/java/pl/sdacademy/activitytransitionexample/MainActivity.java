package pl.sdacademy.activitytransitionexample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button anotherActivityRunner;
    Button dialerRunner;
    Button mapRunner;
    Button browserRunner;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anotherActivityRunner = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.name);
        dialerRunner = (Button) findViewById(R.id.button2);
        mapRunner = (Button) findViewById(R.id.button3);
        browserRunner = (Button) findViewById(R.id.button4);

        setListeners();
    }

    private void setListeners() {
        anotherActivityRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anotherActivity = new Intent(MainActivity.this, AnotherActivity.class);
                Log.d(TAG, "name: " + name.getText());
                anotherActivity.putExtra("name", name.getText());
                startActivity(anotherActivity);
            }
        });

        dialerRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                Uri number = Uri.parse("tel:5551234");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                List activities = packageManager.queryIntentActivities(callIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                if (activities.size() > 0) {
                    Log.d(TAG, "Możemy bezpiecznie wystartować dialer");
                    startActivity(callIntent);
                }
            }
        });

        mapRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Map point based on address
                Uri location = Uri.parse("geo:52.2372974,21.0183589?z=17");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });

        browserRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://www.android.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });
    }
}
