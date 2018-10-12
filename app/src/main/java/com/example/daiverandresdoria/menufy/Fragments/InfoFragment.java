package com.example.daiverandresdoria.menufy.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.daiverandresdoria.menufy.R;

public class InfoFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton fab;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        fab = view.findViewById(R.id.fabInfo);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("this is the new information for the user")
                .setTitle("More information");
        builder.setNeutralButton("GOT IT",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
