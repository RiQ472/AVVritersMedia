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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

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
    FirebaseAuth mAuth;
    UserData userdata;
    DocumentReference userRef;
    String userId;
UserDataViewModel userDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();

//        Map<String, String> data = new HashMap<>();
//        FirebaseFirestore.getInstance().collection("test").add(data);
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

    public void saveUserDataToFirestore( UserData user) {
        // Get the user ID from the current authenticated user
        MainActivity mainActivity = MainActivity.this;
        if (user != null) {
            userId=user.getUserId();
            // Save the user data to Firestore in a "users" collection
            db.collection("users")  // "users" is the collection where we store user data
                    .document(user.getUserId())  // Use the userId as the document ID
                    .set(user.getDataList())  // The user object will be saved as a document in Firestore
                    .addOnSuccessListener(aVoid -> {
                        userDataViewModel.setUserData(user);
                        // Successfully saved user data
                        Toast.makeText(mainActivity, "Welcome "+user.getUsername(), Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        // Failed to save user data
                        Toast.makeText(mainActivity, "Error saving user data", Toast.LENGTH_SHORT).show();
                    });
        }
    }
public void saveUserDataToFirestore(){
    MainActivity mainActivity = MainActivity.this;
userdata=userDataViewModel.getUserData().getValue();
    if (userdata != null) {

        userId=userdata.getUserId();
        // Save the user data to Firestore in a "users" collection
        db.collection("users")  // "users" is the collection where we store user data
                .document(userId)  // Use the userId as the document ID
                .set(userdata.getDataList())  // The user object will be saved as a document in Firestore
                .addOnSuccessListener(aVoid -> {
                    // Successfully saved user data
                })
                .addOnFailureListener(e -> {
                    // Failed to save user data
                });
    }
}

    public void updateUserData(UserData user)
    {
        userDataViewModel.setUserData(user);
        saveUserDataToFirestore(user);
    }

    public void updateUserData(String dataType,String data) {
        // Get current userdata from ViewModel
        UserData currentUserData = userDataViewModel.getUserData().getValue();

        if (currentUserData != null) {
            // Modify the specific part of the data

            if(dataType.equals("username")){currentUserData.setUserName(data);}
            if(dataType.equals("password")){currentUserData.setPassword(data);}
            if(dataType.equals("email")){currentUserData.setUserEmail(data);}
            if(dataType.equals("useridea")) {

                String[] parts=data.split(",");
                if(parts.length>1){
                    String title=parts[0];
            String body = null;
                    if(parts.length==2){ body=parts[1];}
                    currentUserData.addIdea(title,body);

                }
            }

            // Update the ViewModel with the modified userdata

            userDataViewModel.setUserData(currentUserData);

            // Optionally, save the updated data to Firestore
            saveUserDataToFirestore();
        }
    }

    public void saveUserChats(){}


}