package com.example.avvritersmedia;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;


import com.example.avvritersmedia.databinding.ActivityMainBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;
import com.example.avvritersmedia.utils.FirebaseUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    ImageButton searchbutton;
TextView chatroom;
    TextView chatroomtest2;
    FirebaseFirestore db;
    UserData userdata;
DrawerLayout drawerLayout;
    FloatingActionButton floatingActionButton;

    ArrayList<UserIdea> userIdeasViewModelArrayList;
    NavigationView navigationView;
UserDataViewModel userDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        userIdeasViewModelArrayList=new ArrayList<UserIdea>();
//        drawerLayout=binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        floatingActionButton=binding.appBarMain.floatingActionButtonMenu;
//        floatingButtonVisible();
//        floatingActionButton.setOnClickListener(view -> {
//            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                binding.drawerLayout.openDrawer(GravityCompat.START);
//            } else {
//                binding.drawerLayout.closeDrawer(GravityCompat.START);
//            }
//        });
//        //navigationView.setCheckedItem();
//
//        mAppBarConfiguration=new AppBarConfiguration.Builder(
//                R.id.nav_profilepg, R.id.nav_myideaspg, R.id.nav_myroomspg,R.id.nav_joinroompg)
//                .setOpenableLayout(drawerLayout)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


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
    public void setUpIdeaList()
    {
        if(!UserDataViewModel.getUserData().getValue().getListOfIdeas().isEmpty())
        {
            userdata=UserDataViewModel.getUserData().getValue();
            ArrayList<UserIdea> ideaArrayListist=new ArrayList<>();
            for(Map.Entry<String,UserIdea> entry:userdata.getListOfIdeas().entrySet())
            {
                UserIdea userIde = null;

                if(entry!=null)
                {
                    userIde=new UserIdea(entry.getValue().getTitle(),entry.getValue().getBody(),entry.getKey());
                }
                ideaArrayListist.add(userIde);
            }
            if(ideaArrayListist!=null|| !ideaArrayListist.isEmpty()){
                userIdeasViewModelArrayList.addAll(ideaArrayListist);
            }
        }
    }
public void floatingButtonVisible()
{
    if(floatingActionButton.getVisibility()== NavigationView.GONE) floatingActionButton.setVisibility(NavigationView.VISIBLE);
    else floatingActionButton.setVisibility(NavigationView.GONE);
}

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

}