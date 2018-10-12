package com.example.daiverandresdoria.menufy.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.daiverandresdoria.menufy.R;

public class AlertsFragment extends Fragment {
    private FloatingActionButton fab;
    private Switch switchAlerts;
    private TextView textAlerts;
    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        fab = view.findViewById(R.id.fabAlert);
        textAlerts = view.findViewById(R.id.text_alerts);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAlerts();
            }
        });
        return view;
    }

    private void DialogAlerts(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View viewAlert = inflater.inflate(R.layout.alerts_dialog,null);
        builder.setView(viewAlert);
        switchAlerts = viewAlert.findViewById(R.id.switch_alerts);
        builder.setPositiveButton("cheked", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (switchAlerts.isChecked()){
                    textAlerts.setText("Alerts Enable");
                }else {
                    textAlerts.setText("Alerts Disable");
                }
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
