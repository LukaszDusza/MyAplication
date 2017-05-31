package pl.sdacademy.print_time_without_proper_sync_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.nameId);
        name.setText(R.string.my_second_name);

        new Thread(job).start();
        Log.d(TAG, "main thread: " + Thread.currentThread().getName());
        name.setText(String.format("Time: %s", new Date()));
    }


    Runnable job = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "job thread: " + Thread.currentThread().getName());
            while (true) {

                try {
                    Thread.sleep(1000);
                  //  name.setText(String.format("Time: %s", new Date()));
                } catch (InterruptedException e) {
                    Log.d(TAG, "Exception occurred");
                }
            }
        }
    };
}
