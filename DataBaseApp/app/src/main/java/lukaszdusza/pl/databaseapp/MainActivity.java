package lukaszdusza.pl.databaseapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    EditText nameField;
    EditText lastNameField;
    Button saveButton;
    Button baseButton;
    TextView infoField;
    Button exitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameField = (EditText) findViewById(R.id.name_field);
        lastNameField = (EditText) findViewById(R.id.lastname_field);
        saveButton = (Button) findViewById(R.id.save_button);
        baseButton = (Button) findViewById(R.id.base_button);
        infoField = (TextView) findViewById(R.id.info_field);
        exitButton = (Button) findViewById(R.id.exit_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameField.getText().toString();
                String lastName = lastNameField.getText().toString();
                infoField.setText(name + " " + lastName);
                nameField.setText("");
                lastNameField.setText("");


            }
        });

        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                infoField.setText("It still does not work");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        Log.d(TAG, String.format("Current package name is: [%s]", getApplicationContext().getPackageName()));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.APPLICATION_ID));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.BUILD_TYPE));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.DEBUG));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.FLAVOR));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.VERSION_CODE));
        Log.d(TAG, String.format("INFORMACJE O APLIKACJI: ", BuildConfig.VERSION_NAME));



    }
}