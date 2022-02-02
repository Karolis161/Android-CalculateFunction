package com.example.egzovar2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    EditText editTextX1, editTextX2, editTextY1, editTextY2;
    TextView textViewResult;
    Button button;
    int x1, x2, y1, y2, result;
    Bundle bundle = new Bundle();
    FirstFragment firstFragment = new FirstFragment();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        editTextX1 = view.findViewById(R.id.editTextX1);
        editTextX2 = view.findViewById(R.id.editTextX2);
        editTextY1 = view.findViewById(R.id.editTextY1);
        editTextY2 = view.findViewById(R.id.editTextY2);
        textViewResult = view.findViewById(R.id.result);
        button = view.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1 = Integer.parseInt(String.valueOf(editTextX1.getText()));
                x2 = Integer.parseInt(String.valueOf(editTextX2.getText()));
                y1 = Integer.parseInt(String.valueOf(editTextY1.getText()));
                y2 = Integer.parseInt(String.valueOf(editTextY2.getText()));
                result = (y2 - y1) / (x2 - x1);
                textViewResult.setText(String.valueOf(result));

                bundle.putInt("x1", x1);
                bundle.putInt("x2", x2);
                bundle.putInt("y1", y1);
                bundle.putInt("y2", y2);

                firstFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, firstFragment)
                        .commit();
            }
        });
        return view;
    }
}