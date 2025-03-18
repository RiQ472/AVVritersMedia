package com.example.avvritersmedia;

import static android.view.View.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.avvritersmedia.databinding.FragmentFirstBinding;
import com.example.avvritersmedia.usersdata.UserData;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonGetstarted.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        replaceFragment(new SignInPg());
                    }
                });
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}