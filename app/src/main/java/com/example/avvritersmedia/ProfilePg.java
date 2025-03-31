package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avvritersmedia.databinding.FragmentProfilePgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;

public class ProfilePg extends Fragment {


FragmentProfilePgBinding binding;
ImageButton btdBack,btnMyIdeasLine,btnMyPostLine;
Button btnMyIdeas,btnMyPost;
ImageView viewUsername;
TextView textView;
UserData userData;
    public ProfilePg() {
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
        binding=FragmentProfilePgBinding.inflate(inflater, container, false);
        userData=new UserData();
btdBack=binding.imageButton2;
btnMyIdeasLine=binding.buttonMyIdeasLine;
btnMyPostLine=binding.buttonMyPostLine;
btnMyPost=binding.buttonMyPost;
btnMyIdeas=binding.buttonMyIdeas;
        viewUsername=binding.imageViewPost;
        textView=binding.textViewUsername;
        userData= UserDataViewModel.getUserData().getValue();
        textView.setText(userData.getUsername());
        viewUsername.setVisibility(View.INVISIBLE);
btnMyIdeasLine.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnMyIdeas.setOnClickListener(view1 -> {
            viewUsername.setVisibility(View.VISIBLE);
            btnMyIdeasLine.setVisibility(View.VISIBLE);
            btnMyPostLine.setVisibility(View.INVISIBLE);

        });
        btdBack.setOnClickListener(view1 -> replaceFragment(new InspirationPg()));
        btnMyPost.setOnClickListener(view1 -> {
            viewUsername.setVisibility(View.INVISIBLE);
            btnMyIdeasLine.setVisibility(View.INVISIBLE);
            btnMyPostLine.setVisibility(View.VISIBLE);

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