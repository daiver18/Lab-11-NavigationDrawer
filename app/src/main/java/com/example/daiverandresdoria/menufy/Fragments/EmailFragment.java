package com.example.daiverandresdoria.menufy.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daiverandresdoria.menufy.R;

public class EmailFragment extends Fragment {

    private EditText inputEmail;
    private TextView email;
    private FloatingActionButton fab;
    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        email = view.findViewById(R.id.text_Email);
        fab = view.findViewById(R.id.fabEmail);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogEmail();
            }
        });
        return view;
    }

    private void DialogEmail(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View viewDialog = inflater.inflate(R.layout.email_dialog,null);
        builder.setView(viewDialog);
        inputEmail = viewDialog.findViewById(R.id.input_email_dialog);
        builder.setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!inputEmail.getText().toString().isEmpty()){
                    String newEmail = inputEmail.getText().toString().trim();
                    email.setText(newEmail);
                }else {
                    Toast.makeText(getContext(),"input a valid email",Toast.LENGTH_SHORT).show();
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
