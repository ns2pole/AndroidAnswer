package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.example.myapplication.MainActivity;

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("本当にキャンセルしますか？");
        builder.setPositiveButton("yes", new DialogButtonClickListener());
        builder.setNegativeButton("no", new DialogButtonClickListener());
        return builder.create();
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int integer) {
            switch (integer) {
                case DialogInterface.BUTTON_POSITIVE:
                    TextView tv1 = getActivity().findViewById(R.id.id1);
                    TextView tv2 = getActivity().findViewById(R.id.id2);
                    TextView tv3 = getActivity().findViewById(R.id.id3);
                    tv1.setText("0");
                    tv2.setText("0");
                    tv3.setText("0");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    }
}