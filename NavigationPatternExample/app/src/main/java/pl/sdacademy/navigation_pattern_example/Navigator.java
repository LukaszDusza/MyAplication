package pl.sdacademy.navigation_pattern_example;

import android.content.Context;
import android.content.Intent;

public class Navigator {
    public Navigator() {
        // empty
    }

    public void navigateToMainActivity2(Context context) {
        if (null != context) {
            Intent intentToLaunch = new Intent(context, Main2Activity.class);
            context.startActivity(intentToLaunch);
    }
    }
    
    // TODO - implement navigateToActivity3
}
