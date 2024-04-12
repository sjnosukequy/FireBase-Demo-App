package com.example.group_work;


import static androidx.core.content.ContextCompat.getSystemService;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


// Instances of this class are fragments representing a single
// object in the collection.
public class DownFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    ArrayList<String> list = new ArrayList<String>();
    RecyclerviewAdapter adapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_down, container, false);
        list.add("https://fptshop.com.vn/uploads/originals/2023/11/14/638356007024019763_anime-ai-la-gi-bat-mi-cach-tao-anime-bang-ai-cuc-don-gian.png");
        adapter = new RecyclerviewAdapter(view.getContext(), list);
        recyclerView = view.findViewById(R.id.recycler_view);
        Refesh(view);

        Button button = view.findViewById(R.id.Down_Butt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog(view);
            }
        });
        return view;
    }

    public void Refesh(View view){
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void showInputDialog(View view2) {
        AlertDialog.Builder al = new AlertDialog.Builder(view2.getContext());
        View view = getLayoutInflater().inflate(R.layout.input_dilaog, null);
        al.setView(view);

        final EditText editText = view.findViewById(R.id.input);

        al.setPositiveButton("Download", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                list.add( String.valueOf( editText.getText() ) );
                Refesh(view);
            }
        });

        al.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        al.show();
    }
}