package pl.sdacademy.enumsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

enum CoffeSizes {
    SMALL,
    NORMAL,
    LARGE // semicolon is optional
}


enum CoffeeFlavors {
    CARAMEL,
    CREAM,
    VANILLA

}

enum CoffeSizesWithDetails {
    SMALL(100),
    NORMAL(250),
    LARGE(400),
    EXTRA_LARGE(800) {
        @Override
        List<CoffeeFlavors> getAvailableFlavors() {
            return Arrays.asList(CoffeeFlavors.CARAMEL, CoffeeFlavors.CREAM);
        }
    }; // semicolon is required here

    private int capacityInMl;

    CoffeSizesWithDetails(int capacityInMl) {
        this.capacityInMl = capacityInMl;
    }

    int getCapacityInMl() {
        return capacityInMl;
    }

    List<CoffeeFlavors> getAvailableFlavors() {
        return Arrays.asList(CoffeeFlavors.VANILLA);
    }
}

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

        CoffeSizesWithDetails myCoffe = CoffeSizesWithDetails.EXTRA_LARGE;
        Log.d(TAG, "Enum tests...");
        Log.d(TAG, "My favorite coffee size is: " + myCoffe.name());
        Log.d(TAG, "Its capacity is: " + myCoffe.getCapacityInMl());
        Log.d(TAG, "Its flavor can be: ");
        for (CoffeeFlavors flavor : myCoffe.getAvailableFlavors()) {
            Log.d(TAG, flavor.name());
        }

        Log.d(TAG, "Coffee has the following flavors: ");
        // look at the values() method
        for (CoffeeFlavors flavor : CoffeeFlavors.values()) {
            Log.d(TAG, flavor.name());
        }
    }


}