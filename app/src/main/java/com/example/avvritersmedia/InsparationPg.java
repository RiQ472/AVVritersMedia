package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

        binding.buttonIdeapg.setOnClickListener(v ->
                NavHostFragment.findNavController(InsparationPg.this)
                        .navigate(R.id.action_InsoarationPg_to_Ideapg)
        );
        binding.buttonWritersblockpg.setOnClickListener(v ->
                NavHostFragment.findNavController(InsparationPg.this)
                        .navigate(R.id.action_InsoarationPg_to_WritersBlockPg)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}