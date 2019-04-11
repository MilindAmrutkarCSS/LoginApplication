package com.example.loginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;
    private IItemClick iItemClick;

    public DataAdapter(Context context, List<Data> dataList, IItemClick iItemClick) {
        this.context = context;
        this.dataList = dataList;
        this.iItemClick = iItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Data data = dataList.get(position);
        holder.textView.setText(data.getName());
        holder.checkBox.setChecked(data.isSelected());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iItemClick.onItemClick(data.getName());
            }
        });

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.isSelected()) {
                    iItemClick.onItemUncheck(data.getName());
                    holder.checkBox.setChecked(false);
                    dataList.get(position).setSelected(false);
                } else {
                    iItemClick.onItemCheck(data.getName());
                    holder.checkBox.setChecked(true);
                    dataList.get(position).setSelected(true);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CheckBox checkBox;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvName);
            checkBox = itemView.findViewById(R.id.tvCheckBox);

        }
    }
}
