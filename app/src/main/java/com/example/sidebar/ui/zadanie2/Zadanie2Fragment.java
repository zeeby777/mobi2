package com.example.sidebar.ui.zadanie2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sidebar.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Zadanie2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Zadanie2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int currentIndex = 0;

    public Zadanie2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Zadanie2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Zadanie2Fragment newInstance(String param1, String param2) {
        Zadanie2Fragment fragment = new Zadanie2Fragment();
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
        View rootView = inflater.inflate(R.layout.fragment_zadanie2, container, false);

        Button buttonLeft = rootView.findViewById(R.id.buttonLeft);
        Button buttonRight = rootView.findViewById(R.id.buttonRight);

        TextView description = rootView.findViewById(R.id.textViewDescription);

        ImageView oranges = rootView.findViewById(R.id.imageViewOranges);



        int[] orangeTab = new int[] {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4
        };

        String[] descriptions = new String[] {
                "xd",
                "xd1",
                "xd2",
                "xd3",
                "xd4"
        };

        buttonLeft.setEnabled(false);
        buttonLeft.setAlpha(0.5F);

        description.setText(descriptions[currentIndex]);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex == 6) {
                    buttonRight.setEnabled(true);
                    buttonRight.setAlpha(1F);
                }
                currentIndex-= 1;
                oranges.setImageResource(orangeTab[currentIndex]);
                description.setText(descriptions[currentIndex]);
                if(currentIndex == 0) {
                    buttonLeft.setEnabled(false);
                    buttonLeft.setAlpha(0.5F);
                }
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex == 0) {
                    buttonLeft.setEnabled(true);
                    buttonLeft.setAlpha(1F);
                }
                currentIndex+= 1;
                oranges.setImageResource(orangeTab[currentIndex]);
                description.setText(descriptions[currentIndex]);
                if(currentIndex == orangeTab.length - 1) {
                    buttonRight.setEnabled(false);
                    buttonRight.setAlpha(0.5F);
                }
            }
        });

        return rootView;
    }
}