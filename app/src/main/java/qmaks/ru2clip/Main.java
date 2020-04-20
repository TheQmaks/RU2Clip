package qmaks.ru2clip;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Main extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        startService(new Intent(this, ClipboardService.class));
    }
}