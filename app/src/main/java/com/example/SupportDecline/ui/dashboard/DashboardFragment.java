package com.example.SupportDecline.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.SupportDecline.APPData;
import com.example.SupportDecline.PayActivity;
import com.example.SupportDecline.PayHistoryActivity;
import com.example.SupportDecline.PayRecordActivity;
import com.example.SupportDecline.R;
import com.example.SupportDecline.ui.login.LoginActivity;

public class DashboardFragment extends Fragment {

    /**
     * {@inheritDoc}
     */
    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.home_txt);
        TextView cj = root.findViewById(R.id.cj);
        TextView cjzl = root.findViewById(R.id.cz_jl);
        TextView czxq = root.findViewById(R.id.txt_history);
        Button logout = root.findViewById(R.id.logut_btn);
        ImageView my = root.findViewById(R.id.my_im);
        TextView smss = root.findViewById(R.id.syts_txt);//剩余短信total条数
        smss.setText("");
        TextView txt_login_number = root.findViewById(R.id.txt_login_account);
        //show login account number
        APPData appData = (APPData) getActivity().getApplicationContext();
        txt_login_number.setText(appData.phoneNumber);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(getContext(), LoginActivity.class);

                startActivity(home);

            }
        });

        cj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), PayActivity.class);
                startActivity(i);

            }
        });

        cjzl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), PayRecordActivity.class);
                startActivity(i);

            }
        });
        czxq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), PayHistoryActivity.class);
                startActivity(i);

            }
        });

        return root;
    }
}