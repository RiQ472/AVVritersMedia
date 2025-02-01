package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avvritersmedia.databinding.FragmentIdeaPgBinding;


public class IdeaPg extends Fragment {

    FragmentIdeaPgBinding binding;
    public IdeaPg() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentIdeaPgBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonInspirationpgIdpg.setOnClickListener(v ->
                NavHostFragment.findNavController(IdeaPg.this)
                        .navigate(R.id.action_InsoarationPg_to_Ideapg)
        );
        binding.buttonWritersblockpgIdpg.setOnClickListener(v ->
                NavHostFragment.findNavController(IdeaPg.this)
                        .navigate(R.id.action_InsoarationPg_to_WritersBlockPg)
        );
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}