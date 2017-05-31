package lukaszdusza.pl.toast_app;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class Window extends AppCompatActivity {
TextView textField;

    Intent intent;

String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.window);
        textField = (TextView)findViewById(R.id.textField);
       intent = getIntent();
        intent.getExtras();
        textField.setText(" " + login);

    }
}