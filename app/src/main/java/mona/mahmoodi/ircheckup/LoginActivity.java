package mona.mahmoodi.ircheckup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mona.mahmoodi.ircheckup.Help.InputValidator;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btnLogin;
    private String MY_PREFS_NAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ( txtEmail.getText().toString().trim() );
                String password = ( txtPassword.getText().toString().trim() );

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "ایمیل خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "رمز عبور را وارد کنید", Toast.LENGTH_SHORT).show();
                }
                if (!InputValidator.checkEmail(email)) {
                    Toast.makeText(LoginActivity.this, "ایمیل نامعتبر است", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(LoginActivity.this, "حداقل ۶ کاراکتر برای رمز عبور وارد کنید", Toast.LENGTH_SHORT).show();
                } else {
                    /**put data in shared preference*/
                    try {
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("email", String.valueOf(txtEmail));
                        editor.putString("pass", String.valueOf(txtPassword));
                        editor.apply();
                    } catch (Exception e) {
                    }
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                }
            }
        });

    }
}
