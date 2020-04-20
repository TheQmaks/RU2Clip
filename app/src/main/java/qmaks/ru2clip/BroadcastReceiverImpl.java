package qmaks.ru2clip;

import android.content.*;
import android.util.Base64;
import android.app.Activity;
import android.text.ClipboardManager;
import java.nio.charset.StandardCharsets;

/*
 * Receives broadcast commands and controls clipboard accordingly.
 * The broadcast receiver is active only as long as the application, or its service is active.
 */
public class BroadcastReceiverImpl extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (intent.getAction().toLowerCase().equals("set")) {
            String base64 = intent.getStringExtra("base64");
            if (base64 != null) {
                cb.setText(new String(Base64.decode(base64, Base64.DEFAULT), StandardCharsets.UTF_8));
                setResultCode(Activity.RESULT_OK);
                setResultData("Text is copied into clipboard.");
            } else {
                setResultCode(Activity.RESULT_CANCELED);
                setResultData("No text is provided. Use -e base64 \"encrypted symbols\"");
            }
        }
    }
}