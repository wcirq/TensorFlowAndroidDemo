package com.tfcamerademo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TestFragment extends Fragment implements FragmentCompat.OnRequestPermissionsResultCallback, View.OnClickListener {
    public boolean VIEW_TYPE = true;

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_activit, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if (VIEW_TYPE){
            fragment = new AnotherRightFragment();
            VIEW_TYPE = false;
        }else {
            fragment = new RightFragment();
            VIEW_TYPE = true;
        }
        switch (v.getId()) {
            case R.id.button:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager. beginTransaction();
                transaction.replace(R.id.right_layout, fragment);
                transaction.commit();
                break;
            default:
                break;
        }
    }
}
