package pl.sdacademy.bonus_sync;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button addBonus;
    private EditText bonusAmount;
    private EditText myMoneySum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBonus = (Button) findViewById(R.id.addBonusButton);
        bonusAmount = (EditText) findViewById(R.id.bonusAmount);
        myMoneySum = (EditText) findViewById(R.id.myMoneySum);

        addBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Starting bonus generator...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d(TAG, "Interrupted Exception");
                }

                Log.d(TAG, "Bonus generated!");
                try {
                    long bonus = Long.parseLong(bonusAmount.getText().toString());
                    long currentMoneySum = Long.parseLong(myMoneySum.getText().toString());
                    myMoneySum.setText("" + (bonus + currentMoneySum));
                } catch (NumberFormatException e) {
                    Log.d(TAG, "NumberFormatException");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
