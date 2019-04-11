package com.example.loginapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialogRecyclerView extends Dialog implements IItemClick {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    Context context;

    Set<String> checkedItems;

    public CustomDialogRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_dialog_recycler_view);
        ButterKnife.bind(this);

        DataAdapter dataAdapter = new DataAdapter(context, generateData(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
        checkedItems = new HashSet<>();
    }

    private List<Data> generateData() {
        GenerateData.setData();
        return GenerateData.getData();
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {
        Intent intent = new Intent(context, SelectedMembersActivity.class);
        String[] names = new String[checkedItems.size()];
        checkedItems.toArray(names);
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(names));
        intent.putStringArrayListExtra("names", stringArrayList);
        context.startActivity(intent);

    }

    @Override
    public void onItemClick(String name) {
        Toast.makeText(context, "Selected: " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemCheck(String name) {
        checkedItems.add(name);

    }

    @Override
    public void onItemUncheck(String name) {
        checkedItems.remove(name);
    }
}
