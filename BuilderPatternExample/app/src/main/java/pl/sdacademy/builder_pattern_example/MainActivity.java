package pl.sdacademy.builder_pattern_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import pl.sdacademy.builder_pattern_example.model.User;
import pl.sdacademy.builder_pattern_example.model.UserWithBuilder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        User basicUser = new User();
        basicUser.setFirstName("John");
        basicUser.setLastName("Doe");
        Log.d(TAG, "Name of basicUser: " + basicUser.getFirstName());
        Log.d(TAG, "Surname of basicUser: " + basicUser.getLastName());
        Log.d(TAG, "Age of basicUser: " + basicUser.getAge());
        Log.d(TAG, "Address of basicUser: " + basicUser.getAddress());
        Log.d(TAG, "Phone of basicUser: " + basicUser.getPhone());

        UserWithBuilder builderUser =
                new UserWithBuilder.UserBuilder("John", "Doe").age(30).phone("555-55-555").address("unknown").build();
        Log.d(TAG, "Name of builderUser: " + builderUser.getFirstName());
        Log.d(TAG, "Surname of builderUser: " + builderUser.getLastName());
        Log.d(TAG, "Age of builderUser: " + builderUser.getAge());
        Log.d(TAG, "Address of builderUser: " + builderUser.getAddress());
        Log.d(TAG, "Phone of builderUser: " + builderUser.getPhone());
    }
}
