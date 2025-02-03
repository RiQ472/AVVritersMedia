package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avvritersmedia.databinding.FragmentInsparationPgBinding;

public class InsparationPg extends Fragment {

FragmentInsparationPgBinding binding;
    public InsparationPg() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentInsparationPgBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonIdeaPgInsPg.setOnClickListener(view1 -> replaceFragment(new IdeaPg()));
        binding.buttonWritersBlockPgInsPg.setOnClickListener(view2 -> replaceFragment(new WritersBlockPg()));
        binding.buttonAddIdea.setOnClickListener(view1 -> replaceFragment(new AddUserIdeaPg()));
        binding.buttonMyIdeaInsPg.setOnClickListener(view1 -> replaceFragment(new UserIdeasPg()));
        binding.buttonRooms.setOnClickListener(view1 -> replaceFragment(new UserChatRooms()));
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}