package pl.sdacademy.earth_info_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class EarthPicture extends AppCompatActivity {
    private static final String TAG = EarthPicture.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_picture);

        Intent startingIntent = getIntent();
        String valueToShow = "Ziemia jest dla mnie: " + startingIntent.getExtras().getString("pl.sdacademy.earth_info_exampl.key");
        Toast.makeText(this, valueToShow, Toast.LENGTH_LONG).show();


    }
}
