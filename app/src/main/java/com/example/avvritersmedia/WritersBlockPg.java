package com.example.avvritersmedia;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.avvritersmedia.databinding.FragmentWritersBlockPgBinding;


public class WritersBlockPg extends Fragment {


    FragmentWritersBlockPgBinding binding;
    Button writersblock;
    Button idea;
    Button inspiration;
    private ImageButton btnInspiration, btnIdea, btnWritersBlock,btnProfile,btnJoinRoom,btsChatrooms, btnMyIdea,menu,plus;
    RelativeLayout relativeLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentWritersBlockPgBinding.inflate(inflater,container,false);
        relativeLayout=binding.relativeLayoutMenu;
        menu=binding.imageButtonMenu;
        btnProfile=binding.imageButtonProfile;
        btsChatrooms=binding.imageButtonMyRooms;
        btnMyIdea=binding.imageButtonMyIdeas;
        writersblock = binding.buttonWritersBlock;
        idea = binding.buttonIdea;
        inspiration = binding.buttonInspiration;
        plus = binding.buttonAddIdea;

        btnInspiration=binding.buttonInspoLine;
        btnIdea=binding.buttonIdeaLine;
        btnWritersBlock=binding.buttonWritersBlockLine;
        resetButtonStates();
        btnWritersBlock.setVisibility(View.VISIBLE);

        return binding.getRoot();
    }
    @SuppressLint("ClickableViewAccessibility")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idea.setOnClickListener(v -> replaceFragment(new IdeaPg()));
        inspiration.setOnClickListener(v -> replaceFragment(new InspirationPg()));
        writersblock.setOnClickListener(v -> replaceFragment(new WritersBlockPg()));
        btnMyIdea.setOnClickListener(v -> replaceFragment(new UserIdeasPg()));
        btsChatrooms.setOnClickListener(v -> replaceFragment(new UserChatRooms()));
        btnProfile.setOnClickListener(v -> replaceFragment(new ProfilePg()));
        plus.setOnClickListener(v -> replaceFragment(new AddUserIdeaPg()));
        menu.setOnClickListener(view1 -> {
            if(relativeLayout.getVisibility()==View.GONE)relativeLayout.setVisibility(View.VISIBLE);
            else relativeLayout.setVisibility(View.GONE);
        });
        binding.getRoot().setOnTouchListener((v, event) -> {
            if (relativeLayout.getVisibility() == View.VISIBLE) {
                relativeLayout.setVisibility(View.GONE);
            }
            return false;
        });
    }
    private void resetButtonStates() {
        // Reset all buttons to default state
        btnInspiration.setVisibility(View.INVISIBLE);
        btnIdea.setVisibility(View.INVISIBLE);
        btnWritersBlock.setVisibility(View.INVISIBLE);
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