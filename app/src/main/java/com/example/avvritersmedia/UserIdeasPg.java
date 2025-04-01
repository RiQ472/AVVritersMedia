package com.example.avvritersmedia;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.avvritersmedia.adapter.ButtonWithTitleAdapter;
import com.example.avvritersmedia.databinding.FragmentUserIdeasPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserIdeasPg extends Fragment implements ButtonWithTitleAdapter.ButtonClickListener {


    FragmentUserIdeasPgBinding binding;
     ButtonWithTitleAdapter adapter;
    UserData userData;
    RecyclerView recyclerView;
    String title, body,ideaId;
    ArrayList<UserIdea> listideas;
    ImageButton back;

    public UserIdeasPg() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint({"ResourceAsColor", "NotifyDataSetChanged"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserIdeasPgBinding.inflate(inflater, container, false);
        recyclerView=binding.recyclerViewIdeasList;







        back=binding.buttonBackMyIdeasPg;
setUpIdeaList();
        adapter = new ButtonWithTitleAdapter(this.getContext(),listideas, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

back.setOnClickListener(view1 -> replaceFragment(new InspirationPg()));
    }

    @Override
    public void onButtonClick(int position, String title, String body, String ideaId) {
replaceFragment(new AddUserIdeaPg(new UserIdea(title,body,ideaId)));
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).commit();
    }
    public void setUpIdeaList()
    {
        if(!UserDataViewModel.getUserData().getValue().getListOfIdeas().isEmpty())
        {

            userData=UserDataViewModel.getUserData().getValue();
            ArrayList<UserIdea> ideaArrayList=new ArrayList<>();
            for(Map.Entry<String,UserIdea> entry:userData.getListOfIdeas().entrySet())
            {
                UserIdea userIde = null;

                if(entry!=null)
                {
                    userIde=new UserIdea(entry.getValue().getTitle(),entry.getValue().getBody(),entry.getKey());
                }
                ideaArrayList.add(userIde);
            }
            if(ideaArrayList!=null|| !ideaArrayList.isEmpty()){
                listideas=new ArrayList<>();
                listideas.addAll(ideaArrayList);
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }


}