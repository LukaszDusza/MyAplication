package pl.sdacademy.basic_dialog_example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button simpleDialogRunner;
    private Button dialogWithButtonsRunner;
    private AlertDialog.Builder simpleDialogBuilder;
    private AlertDialog.Builder dialogWithButtonsBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleDialogBuilder = new AlertDialog.Builder(this);
        simpleDialogBuilder.setMessage("Jak się masz?").setTitle("Pytanie");
        simpleDialogRunner = (Button) findViewById(R.id.dialogFireButton);
        simpleDialogRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleDialogBuilder.create().show();
            }
        });

        dialogWithButtonsBuilder = new AlertDialog.Builder(this);
        dialogWithButtonsBuilder.setTitle("Sprawdzanie formy...").setMessage("Jaka jest Twoja dzisiejsza forma?");

        dialogWithButtonsBuilder.setPositiveButton("Dobra", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Czuję się świetnie!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Pressed key: " + which);
            }
        }).setNegativeButton("Zła", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Te enumy wykończyły mnie!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Pressed key: " + which);
            }
        }).setNeutralButton("Przetrwam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Jakoś przetrwam", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Pressed key: " + which);
            }
        });
        dialogWithButtonsRunner = (Button) findViewById(R.id.dialogWithButtons);
        dialogWithButtonsRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogWithButtonsBuilder.create().show();
            }
        });
    }
}
