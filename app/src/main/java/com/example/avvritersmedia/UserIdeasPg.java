package com.example.avvritersmedia;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.avvritersmedia.adapter.ButtonWithTitleAdapter;
import com.example.avvritersmedia.databinding.FragmentUserIdeasPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;
import com.example.avvritersmedia.utils.FirebaseUtil;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserIdeasPg extends Fragment {


    FragmentUserIdeasPgBinding binding;
     ButtonWithTitleAdapter adapter;
    //TextView textView;
    UserData userData;
    RecyclerView recyclerView;
    String title, body,IdeaId;
    int textviewcount;
    List<UserIdea> listideas;
    ImageButton back;

    public UserIdeasPg() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint({"ResourceAsColor", "NotifyDataSetChanged"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserIdeasPgBinding.inflate(inflater, container, false);
        recyclerView=binding.recyclerViewIdeasList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        back=binding.buttonBackMyIdeasPg;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                LinearLayoutManager.VERTICAL
        );
        recyclerView.addItemDecoration( new DividerItemDecoration(
                recyclerView.getContext(),
                LinearLayoutManager.VERTICAL
        ));;
        // Get the ViewModel
        listideas=new ArrayList<>();
        userData = UserDataViewModel.getUserData().getValue();
        if (userData != null && userData.getListOfIdeas() != null&& !userData.getListOfIdeas().isEmpty()) {
            for (Map.Entry<String, UserIdea> entry : userData.getListOfIdeas().entrySet()) {
                if (entry!=null && entry.getValue() !=null){
                 IdeaId=entry.getKey();
                title=entry.getValue().getTitle();
                body=entry.getValue().getBody();
                    UserIdea idea=new UserIdea(title,body,IdeaId);
                    listideas.add(idea);
                }

              //  else createTextView(entry.getValue().getTitle());

                textviewcount++;
            }
        }
        adapter = new ButtonWithTitleAdapter(listideas,  ( title, body,id) -> {
        adapter.notifyDataSetChanged();
            replaceFragment(new AddUserIdeaPg(title,body,id));
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tittle=getArguments().getString("A");
back.setOnClickListener(view1 -> replaceFragment(new InsparationPg()));
        //textView.setText(tittle);
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