package com.example.avvritersmedia;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import com.example.avvritersmedia.databinding.ActivityMainBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;
import com.example.avvritersmedia.utils.FirebaseUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ImageButton searchbutton;
TextView chatroom;
    TextView chatroomtest2;
    FirebaseFirestore db;
    UserData userdata;

    private Button btnInspiration, btnIdea, btnWritersBlock;
    DocumentReference userRef;
    String userId;
UserDataViewModel userDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        new FirebaseUtil(this);
        db = FirebaseFirestore.getInstance();
        userdata = new UserData();
userDataViewModel=new ViewModelProvider(this).get(UserDataViewModel.class);
userdata=userDataViewModel.getUserData().getValue();
        searchbutton = findViewById(R.id.imageButton_search);
        chatroom = findViewById(R.id.textView_chat1);
        chatroomtest2 = findViewById(R.id.textView_chat2);


        // chatroom.setOnClickListener(view -> { startActivities(new Intent[]{new Intent(MainActivity.this, ChatActivity.class)});});
        // chatroomtest2.setOnClickListener(view -> { startActivities(new Intent[]{new Intent(MainActivity.this, ChatActivity.class)});});
//        searchbutton.setOnClickListener(view -> {
//            startActivities(new Intent[]{new Intent(MainActivity.this, SearchRoomActivity.class)});
//        });


    }


}