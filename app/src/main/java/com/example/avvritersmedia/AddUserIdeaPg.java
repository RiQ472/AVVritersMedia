package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.avvritersmedia.databinding.FragmentAddUserIdeaPgBinding;

public class AddUserIdeaPg extends Fragment {


    FragmentAddUserIdeaPgBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAddUserIdeaPgBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     binding.buttonBackAuipg.setOnClickListener(view1 -> replaceFragment(new InsparationPg()));
     binding.buttonSave.setOnClickListener(view1 -> replaceFragment(newIdea(binding.edittextUserIdeaTittle.getText().toString())));
    }
    public Fragment newIdea(String t)
    {
        Fragment fragment;
        if(!t.isEmpty())
        {
            fragment=new UserIdeasPg(t);

        }
        else
        {fragment=new UserIdeasPg();}
        return fragment;
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