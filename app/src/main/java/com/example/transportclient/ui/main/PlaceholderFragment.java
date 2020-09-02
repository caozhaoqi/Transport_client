package com.example.transportclient.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.transportclient.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    @NonNull
    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PageViewModel pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    /** {@inheritDoc} */
    @SuppressLint("UnknownNullness")
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);

        ListView listView_wfs = root.findViewById(R.id.list_wfs);
        ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < 20; i5++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", "13131313" + i5);

            //往list添加数据
            arr_data.add(map);
        }

        // 新建适配器 ，绑定数据
        String[] from = {"pn"};
        int[] to = {R.id.phone_number};
        SimpleAdapter simp_ada;
        simp_ada = new SimpleAdapter(getContext(), arr_data, R.layout.list_fs_item, from, to);

        listView_wfs.setAdapter(simp_ada);


        View root2 = inflater.inflate(R.layout.fragment_detail, container, false);
        //final TextView textView = root.findViewById(R.id.section_label);

        ListView listView_fs = root2.findViewById(R.id.list_fs);


        ArrayList<Map<String, Object>> arr_data2 = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < 20; i5++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", "13131313" + i5);

            //往list添加数据
            arr_data.add(map);
        }

        // 新建适配器 ，绑定数据
        String[] from2 = {"pn"};
        int[] to2 = {R.id.phone_number};
        SimpleAdapter simp_ada2 = new SimpleAdapter(getContext(), arr_data2, R.layout.list_fs_item, from, to);

        listView_fs.setAdapter(simp_ada2);


//        pageViewModel.getText().observe(getContext(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}