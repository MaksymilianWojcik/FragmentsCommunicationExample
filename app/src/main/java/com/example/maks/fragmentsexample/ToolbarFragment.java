package com.example.maks.fragmentsexample;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by MAKS on 31.08.2017.
 */

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{

    private static int seekValue = 10;
    private static EditText editText;

    ToolbarListener activityCallback;

    public interface ToolbarListener{
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activityCallback = (ToolbarListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);

        editText = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(this);

        final Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    private void buttonClicked(View v) {
        activityCallback.onButtonClick(seekValue, editText.getText().toString());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekValue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
