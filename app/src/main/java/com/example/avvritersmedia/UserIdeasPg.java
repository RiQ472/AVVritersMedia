package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.avvritersmedia.databinding.FragmentUserIdeasPgBinding;

public class UserIdeasPg extends Fragment {


FragmentUserIdeasPgBinding binding;
TextView textView;
String tittle;

public UserIdeasPg(){}
    public UserIdeasPg (String t){
    tittle=t;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentUserIdeasPgBinding.inflate( inflater,container, false);

         binding.textView1.setText(tittle);
       // binding.textView1.setTextSize();

        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //tittle=getArguments().getString("A");
        binding.buttonBackMyIdeasPg.setOnClickListener(view1 -> replaceFragment(new InsparationPg()));
        //textView.setText(tittle);
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