package pl.sdacademy.android_widgets_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttons;
    private Button checkboxes;
    private Button radioButtons;
//    private Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        buttons = (Button) findViewById(R.id.buttons);
//        checkboxes = (Button) findViewById(R.id.checkboxes);
//        radioButtons = (Button) findViewById(R.id.radioButtons);
    }


    public void moveToButtons(View view) {
        Intent intent = new Intent(this, Buttons.class);
        startActivity(intent);
    }

    public void moveToCheckBoxes(View view) {
        Intent intent = new Intent(this, Checkboxes.class);
        startActivity(intent);
    }

    public void moveToRadioButtons(View view) {
        Intent intent = new Intent(this, RadioButtons.class);
        startActivity(intent);
    }
}
