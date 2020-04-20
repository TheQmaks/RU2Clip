package qmaks.ru2clip;

import android.content.Intent;
import android.app.IntentService;

public class ClipboardService extends IntentService {
    public ClipboardService() {
        super("ClipboardService");
    }

    /* Define service as sticky so that it stays in background */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // start itself to ensure our broadcast receiver is active
        startService(new Intent(getApplicationContext(), ClipboardService.class));
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {}
}