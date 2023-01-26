package com.example.bottomsheetdialogfragmentandrecycleview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {
    private List<String> listData;
    private RecyclerView recyclerView;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View viewDialog = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet, null);
        bottomSheetDialog.setContentView(viewDialog);

        initView(viewDialog);

        return bottomSheetDialog;
    }

    private void initView(View viewDialog) {
        recyclerView = viewDialog.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> listData = new ArrayList<>();
        listData.add("Item 1");
        listData.add("Item 2");
        listData.add("Item 3");
        listData.add("Item 4");
        listData.add("Item 5");
        listData.add("Item 6");
        listData.add("Item 7");
        listData.add("Item 8");
        listData.add("Item 9");
        listData.add("Item 10");
        Adapter adapter = new Adapter(listData, new IItemClick() {
            @Override
            public void onClickItem(String item) {
                String text = "Click " + item;
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(adapter);
    }
}
