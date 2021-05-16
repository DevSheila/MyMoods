package com.example.mymoods;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MoodDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mood_dialog, container, false);
        getDialog().setTitle("Simple Dialog");

        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.moodRadioGroup);
//        int selectedId = surveyRadioGroup.getCheckedRadioButtonId();
//        RadioButton selectedRadioButton = (RadioButton) rootView.findViewById(selectedId);
//
//        Log.i("button", selectedId + "");
//        submitButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Log.d("testing", selectedRadioButton.getText().toString());
//
//                dismiss();
//
//            }
//        });

    surveyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton  = (RadioButton)group.findViewById(checkedId);
        }
    });

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = surveyRadioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(v.getContext(),
                            "No answer has been selected",
                            Toast.LENGTH_SHORT)
                            .show();

                    Log.i("value",selectedId +"");
                }
                else {

                    RadioButton radioButton = (RadioButton)surveyRadioGroup.findViewById(selectedId);

                    // Now display the value of selected item
                    // by the Toast message
                    Toast.makeText(v.getContext(),
                            radioButton.getText(),
                            Toast.LENGTH_SHORT)
                            .show();
                    Log.i("value",selectedId +"");
                }
                // i.e. reset all the Radio Buttons
                surveyRadioGroup.clearCheck();
            }

        });
        return rootView;

    }
}