package mona.mahmoodi.ircheckup;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import mona.mahmoodi.ircheckup.Help.BaseActivity;

import static android.content.ContentValues.TAG;

public class SplashActivity extends BaseActivity {
    private static final int SPLASH_SCREEN_LENGTH = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new UserAccess().execute();


    }

    private class UserAccess extends AsyncTask<String, Void, String> {
        private boolean hasError = false;

        @Override
        protected String doInBackground(String... strings) {
            try {
                Log.i(TAG, "doInBackground: ");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (hasError) {
                Toast.makeText(SplashActivity.this, "error", Toast.LENGTH_SHORT).show();
            } else {
                //Todo:check user login
                if (true) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

                }
            }

        }

        @Override
        protected void onPreExecute() {
            hasError = !isNetworkAvailable();
        }//Todo:check net
    }

}
