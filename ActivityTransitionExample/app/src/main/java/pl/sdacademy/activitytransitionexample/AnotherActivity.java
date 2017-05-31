package pl.sdacademy.activitytransitionexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private static final String TAG = AnotherActivity.class.getSimpleName();
    TextView obtainedName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        obtainedName = (TextView) findViewById(R.id.obtainedName);
        Intent intent = getIntent();
        Log.d(TAG, intent.getExtras().toString());
        obtainedName.setText("Otrzymane imie: " + intent.getExtras().getString("name"));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
