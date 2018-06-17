package apgred.com.apgred;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apgred.Apgred;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Apgred.getInstance().init(getApplicationContext(), "nagendra", "nagendra_token");
    }
}
