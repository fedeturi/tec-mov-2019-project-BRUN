package com.theweatherguy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.theweatherguy.R;

public class ProfileFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast toast = Toast.makeText(getActivity(), getString(R.string.under_construction), Toast.LENGTH_SHORT);
        toast.show();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
