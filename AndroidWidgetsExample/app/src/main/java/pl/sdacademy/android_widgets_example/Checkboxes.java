package pl.sdacademy.android_widgets_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.zip.CheckedOutputStream;


public class Checkboxes extends AppCompatActivity {
    Button check;
    CheckBox pear;
    CheckBox orange;
    CheckBox apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes);

        check = (Button) findViewById(R.id.checkButton);
        pear = (CheckBox) findViewById(R.id.pear);
        orange = (CheckBox) findViewById(R.id.orange);
        apple = (CheckBox) findViewById(R.id.apple);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder message = new StringBuilder("Lubisz: ");
                StringBuilder favorites = new StringBuilder();
                if (pear.isChecked()) {
                    favorites.append("gruszki ");
                }
                if (orange.isChecked()) {
                    favorites.append("pomarańcze ");
                }
                if (apple.isChecked()) {
                    favorites.append("jabłka");
                }

                if (favorites.length() > 0) {
                    message.append(favorites);
                } else {
                    message = new StringBuilder("Wybierz coś:)");
                }
                Toast.makeText(Checkboxes.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
