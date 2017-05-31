package lukaszdusza.pl.twoactivitycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private CalendarView calendarView;
    private Button saveButton;
    private Button mounthButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amount);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        saveButton = (Button) findViewById(R.id.saveButton);
        mounthButton = (Button) findViewById(R.id.mounthButton);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                Toast.makeText(MainActivity.this,"zapisano: " + amount.getText(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivitySummary.class);
                intent.putExtra("userAmount.key", amount.getText().toString());

                startActivity(intent);
            }
        });





    }
}
