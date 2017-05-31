package pl.sdacademy.earth_info_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainInfo extends AppCompatActivity {
    private Button button;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

        button = (Button) findViewById(R.id.buttonTransition);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transition = new Intent(MainInfo.this, EarthPicture.class);
                String message = description.getText().toString();
                transition.putExtra("pl.sdacademy.earth_info_exampl.key", message);
               startActivity(transition);



            }
        });

        description = (EditText) findViewById(R.id.myDesc);
    }
}
