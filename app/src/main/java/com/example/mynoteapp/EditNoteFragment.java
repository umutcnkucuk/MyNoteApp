package com.example.mynoteapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class EditNoteFragment extends Fragment {
    private static final String ARG_NOTE = "content";
    private String content;
    private EditText txtContent;
    public EditNoteFragment() {}
    public static EditNoteFragment newInstance(String content) {
        EditNoteFragment fragment = new EditNoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOTE, content);
        fragment.setArguments(args);
        return fragment;
    }

    public void setArguments(Bundle args) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            content = (String)getArguments().getString(ARG_NOTE);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_note, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtContent = view.findViewById(R.id.note_content);
        if (content != null) {
            txtContent.setText(content);
        }
    }
    public String getContent(){
        return txtContent.getText().toString();
    }
}