package pl.sdacademy.print_time_different_thread_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        name.setText("Mariusz");
        name.setText(R.string.my_second_name);

        new Thread(job).start();
        new Thread(anotherJob).start();
    }


    Runnable job = new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            name.setText(String.format("Time: %s", new Date()));
                        }
                    });
                } catch (InterruptedException e) {
                    Log.d(TAG, "Exception occurred");
                }
            }
        }
    };

    Runnable anotherJob = new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(2000);
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
                    name.post(new Runnable() {
                        @Override
                        public void run() {
                            name.setText("Text from another Job...");
                        }
                    });
//                        }
//                    });
                } catch (InterruptedException e) {
                    Log.d(TAG, "Exception occurred");
                }
            }
        }
    };
}
