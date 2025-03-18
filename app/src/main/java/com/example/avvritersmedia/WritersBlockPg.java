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
import android.widget.Button;
import android.widget.ImageButton;

import com.example.avvritersmedia.databinding.FragmentInsparationPgBinding;
import com.example.avvritersmedia.databinding.FragmentWritersBlockPgBinding;


public class WritersBlockPg extends Fragment {


    FragmentWritersBlockPgBinding binding;
    Button rooms;
    Button writersblock;
    Button idea;
    Button inspiration;
    Button myidea;
    ImageButton plus;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentWritersBlockPgBinding.inflate(inflater,container,false);
        rooms = binding.buttonRooms;
        writersblock = binding.buttonWritersBlock;
        idea = binding.buttonIdea;
        inspiration = binding.buttonInspiration;
        myidea = binding.buttonMyIdeas;
        plus = binding.buttonAddIdea;
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idea.setOnClickListener(v -> replaceFragment(new IdeaPg()));
        inspiration.setOnClickListener(v -> replaceFragment(new InsparationPg()));
        writersblock.setOnClickListener(v -> replaceFragment(new WritersBlockPg()));
        rooms.setOnClickListener(v -> replaceFragment(new UserChatRooms()));
        myidea.setOnClickListener(v -> replaceFragment(new UserIdeasPg()));
        plus.setOnClickListener(v -> replaceFragment(new AddUserIdeaPg()));
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