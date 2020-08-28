package com.example.transportclient.ui.home;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.transportclient.APPData;
import com.example.transportclient.R;
import com.example.transportclient.YTActivity;

public class HomeFragment extends Fragment {

    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final LinearLayout linearLayout = root.findViewById(R.id.addli);
        final APPData appData = (APPData) getActivity().getApplicationContext();
        Button[] button = new Button[appData.s_length];

        //显示需要显示的按钮
        for (int i = 0; i < appData.s_length; i++) {
            button[i] = new Button(getContext());
            button[i].setText(appData.logisticsName[i]);
            button[i].setTextSize(24);

            final int index = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), YTActivity.class);
                    intent.putExtra("kdgsc", appData.logisticsName[index]);
                    startActivity(intent);
                }
            });
            linearLayout.addView(button[i]);
        }
        @SuppressLint("CutPasteId")

        final ImageView im = root.findViewById(R.id.img_add);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    showSingleAlertDialog(root);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        return root;
    }

    /**
     * show dialog
     */
    public void showSingleAlertDialog(final View root) {

        final int[] index = new int[100];

        final APPData appData = (APPData) getContext().getApplicationContext();
        final String[] items = appData.logisticsNames;
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
        alertBuilder.setTitle("请选择快递公司");
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getContext(), items[i], Toast.LENGTH_SHORT).show();

                final LinearLayout linearLayout = root.findViewById(R.id.addli);
                final Button button = new Button(getContext());
                String cm = appData.logisticsNames[i];
                index[i] += 1;

                if (index[i] > 1) {

                    Toast.makeText(getContext(), "已经添加", Toast.LENGTH_SHORT).show();
                    button.setVisibility(View.INVISIBLE);

                }

                //第一次添加
                button.setText(cm);
                linearLayout.addView(button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // TODO other
                        Intent i = new Intent(getContext(), YTActivity.class);
                        i.putExtra("companyName", button.getText().toString());
                        startActivity(i);

                    }
                });
            }
        });
        if (getActivity().isFinishing()) {


            alertBuilder.show();

        }

    }


}