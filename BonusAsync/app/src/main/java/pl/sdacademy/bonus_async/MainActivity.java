package pl.sdacademy.bonus_async;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TAG2 = MainActivity.class.getSimpleName();
    private static final Executor executor = Executors.newFixedThreadPool(8);

    private TextView simpleText;
    private Button addBonus;
    private EditText bonusAmount;
    private EditText myMoneySum;
    private SalaryCalculator moneyCalculator;
    private DataProvider data;
    private SalaryResultUpdater updater;
    private Button buttonLog;
    private long currentMoney = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBonus = (Button) findViewById(R.id.addBonusButton);
        bonusAmount = (EditText) findViewById(R.id.bonusAmount);
        myMoneySum = (EditText) findViewById(R.id.myMoneySum);
        moneyCalculator = new SalaryCalculator(executor);
        data = new DataProvider();
        updater = new SalaryResultUpdater();
        buttonLog = (Button) findViewById(R.id.buttonLog);
        simpleText = (TextView) findViewById(R.id.simpleText);



                buttonLog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.d(TAG2, "KLIK!!!!!!!!!!!!!!!!!!!!!!!");
                        simpleText

                    }

                });


        addBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyCalculator.calculateSalary(data, updater);
            }
        });

    }

    private class DataProvider implements SalaryDataCalculatorProvider {

        @Override
        public long provideBonus() {
            long bonus = 0;

            try {
                bonus = Long.parseLong(bonusAmount.getText().toString());
            } catch (NumberFormatException e) {
                Log.d(TAG, "Cannot parse bonus");
            }

            return bonus;
        }

        @Override
        public long provideCurrentMoneySum() {


            try {
                currentMoney = Long.parseLong(myMoneySum.getText().toString());
            } catch (NumberFormatException e) {
                Log.d(TAG, "Cannot parse current money value");
            }
            return currentMoney;
        }
    }

    private class SalaryResultUpdater implements SalaryResultProvider {

        @Override
        public void sendResult(final long result) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myMoneySum.setText("" + result);
                }
            });
        }
    }
}

interface SalaryDataCalculatorProvider {
    long provideBonus();

    long provideCurrentMoneySum();
}

interface SalaryResultProvider {
    void sendResult(long result);
}

class SalaryCalculator {
    private static final String TAG = SalaryCalculator.class.getSimpleName();
    private Executor executor;

    SalaryCalculator(Executor executor) {
        this.executor = executor;
    }

    public void calculateSalary(final SalaryDataCalculatorProvider data, final SalaryResultProvider result) {
        Runnable job = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d(TAG, "InterruptedException");
                }
                long newSalary = data.provideBonus() + data.provideCurrentMoneySum();
                result.sendResult(newSalary);
            }
        };
        executor.execute(job);
    }
}