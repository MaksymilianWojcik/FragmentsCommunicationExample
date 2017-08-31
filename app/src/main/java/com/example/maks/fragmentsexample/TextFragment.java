package com.example.maks.fragmentsexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MAKS on 31.08.2017.
 */

public class TextFragment extends Fragment {

    private static TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.textView1);

        return view;
    }

    public void changeTextProperties(int fontSize, String text){
        textView.setTextSize(fontSize);
        textView.setText(text);
    }
}
