package com.example.loginapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {

    Context context;
    @BindView(R.id.tvEnterName)
    TextView tvEnterName;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.btnSend)
    Button btnSend;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnSend)
    public void onViewClicked() {
        String name = etName.getText().toString();
        if (!TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Name: " + name, Toast.LENGTH_SHORT).show();
            dismiss();
        } else {
            Toast.makeText(context, "Please input your name", Toast.LENGTH_SHORT).show();
        }

    }
}
