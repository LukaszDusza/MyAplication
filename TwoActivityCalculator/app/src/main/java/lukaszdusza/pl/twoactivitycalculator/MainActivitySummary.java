package lukaszdusza.pl.twoactivitycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivitySummary extends AppCompatActivity {
    private TextView textViewSummary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_summary);

        textViewSummary = (TextView) findViewById(R.id.textViewSummary);


        Intent intent = getIntent();

        String summaryText = intent.getExtras().getString("userAmount.key");
        textViewSummary.setText(summaryText);

    }
}
