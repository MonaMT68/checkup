package mona.mahmoodi.ircheckup.Help;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

public class BaseActivity extends Activity {

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isLogin() {
        try {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            //Todo: change key
            return preferences.getBoolean("login", false);
        } catch (Exception e) {
            return false;
        }
    }
}
