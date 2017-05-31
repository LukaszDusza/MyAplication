package pl.sdacademy.android_widgets_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class RadioButtons extends AppCompatActivity {

    private RadioButton rosol;
    private RadioButton barszcz;
    private RadioButton schabowy;

    private RadioButton piwo;
    private RadioButton woda;
    private RadioButton wodka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttons);

    public void jedzenie(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.rosol:
                if (checked) {
                }
                break;

            case R.id.barszcz:
                if (checked) {
                }
                break;

            case R.id.schabowy:
                if (checked) {
                }
                break;


        }
    }


    public void picie(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.piwo:
                if (checked) {
                }
                break;

            case R.id.woda:
                if (checked) {
                }
                break;

            case R.id.wodka:
                if (checked) {
                }
                break;
        }


    }

}

