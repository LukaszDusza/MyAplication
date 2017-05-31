package lukaszdusza.pl.anenum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;


enum Coffe_variants {

    LATTE,
    CAPPUCCINO,
    EXPRESSO,
    AMERICANO;

}

enum Coffe_size {

    SMALL(100),
    MEDIUM(200),
    LARGE(250),
    EXTRA_LARGE(300) {
        @Override
        List<Coffe_variants> getCoffeVariant() {
            return Arrays.asList(Coffe_variants.LATTE, Coffe_variants.AMERICANO);
        }
    };

    private int coffeSize;

    Coffe_size(int coffeSize) {
        this.coffeSize = coffeSize;
    }

    int getCoffeSize() {
        return coffeSize;
    }

    List<Coffe_variants> getCoffeVariant() {
        return Arrays.asList(Coffe_variants.EXPRESSO);
    }

}


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
