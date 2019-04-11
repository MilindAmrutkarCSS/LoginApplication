package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cbRemember)
    CheckBox cbRemember;
    @BindView(R.id.btnForgot)
    TextView btnForgot;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tlUsername)
    TextInputLayout tlUsername;
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tlUserPassword)
    TextInputLayout tlUserPassword;
    String userName, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private boolean validateInputFields() {

        userName = etUserName.getText().toString();
        userPassword = etPassword.getText().toString();

        if (TextUtils.isEmpty(userName) && !(userName.length() >= 5)) {
            tlUsername.setError("Username cannot be empty and should be greater than 5 characters");
            return false;
        }

        if (TextUtils.isEmpty(userPassword) || !isValidPassword(userPassword)) {
            tlUserPassword.setError("Password should be valid");
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @OnClick({R.id.cbRemember, R.id.btnForgot, R.id.btnLogin, R.id.tlUsername, R.id.tlUserPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cbRemember:
                break;

            case R.id.btnForgot:
                Intent intent = new Intent(this, ForgotPasswordActivity.class);
                startActivity(intent);
                break;

            case R.id.btnLogin:
                if(validateInputFields()) {
                    Intent intent2 = new Intent(this, LoginActivity.class);
                    startActivity(intent2);

                } else {

                }
                break;

            case R.id.tlUsername:
                break;

            case R.id.tlUserPassword:
                break;
        }
    }
}
