package lukaszdusza.pl.toast_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private Button button;
    private String textField;
    private EditText password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                textField = "udalo sie zalogowac";
                Toast.makeText(getBaseContext(), textField, Toast.LENGTH_LONG).show();
                login.getText();
                password.getText();


                Intent intent = new Intent(MainActivity.this, Window.class);

                intent.putExtra(login.toString(), "main.key");
                intent.putExtra(password.toString(), ",main2.key");
                startActivity(intent);

            }
        });




    }
}
