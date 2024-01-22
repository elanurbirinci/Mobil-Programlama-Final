package com.example.mobil2.ui.label;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.mobil2.R;


public class LabelFragment extends Fragment {

    private LinearLayout labelContainer;
    private EditText editText;

    // Diğer gerekli tanımlamalar

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_label, container, false);

        labelContainer = view.findViewById(R.id.labelContainer);
        editText = view.findViewById(R.id.editText);

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String labelText = editText.getText().toString();
                if (!TextUtils.isEmpty(labelText)) {
                    addNewLabel(labelText);
                    editText.setText("");
                }
            }
        });

        // Diğer işlemler

        return view;
    }

    private void addNewLabel(String labelText) {
        CheckBox checkBox = new CheckBox(requireContext());
        checkBox.setText(labelText);
        labelContainer.addView(checkBox);
    }
}