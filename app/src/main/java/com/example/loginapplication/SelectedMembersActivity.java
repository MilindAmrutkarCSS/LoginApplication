package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedMembersActivity extends AppCompatActivity {

    ArrayList<String> dataArrayList;
    @BindView(R.id.tvSelectedMembers)
    TextView tvSelectedMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_members2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String employeeNames = "";
        if (intent != null) {
            dataArrayList = intent.getStringArrayListExtra("names");
            for (int i = 0; i < dataArrayList.size(); i++) {
                employeeNames += dataArrayList.get(i);
            }
            tvSelectedMembers.setText(employeeNames);
        }
    }
}
