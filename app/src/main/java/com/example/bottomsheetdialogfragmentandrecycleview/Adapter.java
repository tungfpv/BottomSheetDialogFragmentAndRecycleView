package com.example.bottomsheetdialogfragmentandrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<String> mListData;
    private IItemClick iItemClick;

    public Adapter(List<String> mListData, IItemClick i) {
        this.mListData = mListData;
        this.iItemClick = i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String item = mListData.get(position);
        holder.textViewItem.setText(item);

        holder.textViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iItemClick.onClickItem(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mListData != null) {
            return mListData.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.item_tv);
        }
    }
}
