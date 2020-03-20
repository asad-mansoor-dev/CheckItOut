package com.asad.checkitout.ui.men;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.asad.checkitout.R;

public class MenFragment extends Fragment {

    private MenViewModel menViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menViewModel =
                ViewModelProviders.of(this).get(MenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_men, container, false);
        final TextView textView = root.findViewById(R.id.text_men);
        menViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}