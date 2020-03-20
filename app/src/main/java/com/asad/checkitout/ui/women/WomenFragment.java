package com.asad.checkitout.ui.women;

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

public class WomenFragment extends Fragment {

    private WomenViewModel womenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        womenViewModel =
                ViewModelProviders.of(this).get(WomenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_women, container, false);
        final TextView textView = root.findViewById(R.id.text_women);
        womenViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {  // here changing instead of 'this'  'getViewLifecycleOwner()'
                textView.setText(s);
            }
        });
        return root;
    }
}