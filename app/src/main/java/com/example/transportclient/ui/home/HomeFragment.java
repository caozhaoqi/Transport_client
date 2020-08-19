package com.example.transportclient.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.transportclient.R;
import com.example.transportclient.YTActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button yt = root.findViewById(R.id.yt_btn);
        final Button yd = root.findViewById(R.id.yd_btn);
        final Button zt = root.findViewById(R.id.zt_btn);

        yd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), YTActivity.class);
                i.putExtra("companyName", yd.getText().toString());
                startActivity(i);
            }
        });

        zt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), YTActivity.class);
                i.putExtra("companyName", zt.getText().toString());
                startActivity(i);
            }
        });

        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), YTActivity.class);
                i.putExtra("companyName", yt.getText().toString());
                startActivity(i);
            }
        });
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final ImageView im = root.findViewById(R.id.img_add);

        final LinearLayout linearLayout = root.findViewById(R.id.addli);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Button button = new Button(getContext());
                final EditText et = new EditText(getContext());
                new AlertDialog.Builder(getContext()).setTitle("请输入快递公司名称")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                Toast.makeText(getContext(), et.getText().toString(), Toast.LENGTH_LONG).show();
                                button.setText(et.getText().toString());
                            }
                        }).setNegativeButton("取消", null).show();
                button.setTextSize(24);
                im.setVisibility(View.INVISIBLE);
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
        return root;
    }
}