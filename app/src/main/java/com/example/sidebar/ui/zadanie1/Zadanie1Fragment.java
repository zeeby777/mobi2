package com.example.sidebar.ui.zadanie1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.sidebar.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Zadanie1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Zadanie1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Zadanie1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Zadanie1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Zadanie1Fragment newInstance(String param1, String param2) {
        Zadanie1Fragment fragment = new Zadanie1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_zadanie1, container, false);

        Button button = rootView.findViewById(R.id.button);
        EditText editText = rootView.findViewById(R.id.editTextText);
        CheckBox checkBox = rootView.findViewById(R.id.checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(editText.getText().toString().isEmpty()) {
                    text = "Nie wpisano zadnego tekstu";
                }

                if(checkBox.isChecked()) {
                    Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                }
                else {
                    Snackbar.make(rootView, text, Snackbar.LENGTH_SHORT).show();
                }
            }
        });



        return rootView;
    }
}