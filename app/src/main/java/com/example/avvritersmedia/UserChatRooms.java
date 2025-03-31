package com.example.avvritersmedia;

import static androidx.core.content.ContextCompat.startActivities;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avvritersmedia.databinding.FragmentUserChatRoomsBinding;

public class UserChatRooms extends Fragment {


    FragmentUserChatRoomsBinding binding;
ImageButton btnPublicLine,btnPrivateLine;
Button btnPublic,btnPrivate;
ImageView chatroom2;
TextView chat1T,chat1Txt;
String name,text;

    public UserChatRooms() {
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
        binding = FragmentUserChatRoomsBinding.inflate(inflater, container, false);
        btnPrivateLine=binding.buttonPrivateLine;
        btnPublicLine=binding.buttonPublicLine;
        btnPublic=binding.buttonPublic;
        btnPrivate=binding.buttonPrivate;
        chatroom2=binding.imageView2;
        chat1T=binding.textViewChat1;
        chat1Txt=binding.textView3;
        chatroom2.setVisibility(View.INVISIBLE);
        btnPrivateLine.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imageButton2.setOnClickListener(view1 -> replaceFragment(new InspirationPg()));

btnPrivate.setOnClickListener(view1 -> {
    btnPublicLine.setVisibility(View.INVISIBLE);
    btnPrivateLine.setVisibility(View.VISIBLE);
    chatroom2.setVisibility(View.VISIBLE);
    chat1T.setText("User45");
chat1Txt.setText("How did the test go?");
});
btnPublic.setOnClickListener(view1 -> {
    btnPublicLine.setVisibility(View.VISIBLE);
    btnPrivateLine.setVisibility(View.INVISIBLE);
    chatroom2.setVisibility(View.INVISIBLE);
    chat1T.setText("ChatBot");
    chat1Txt.setText("Welcome to AVVritters Media! if you need any assistance");
});
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}