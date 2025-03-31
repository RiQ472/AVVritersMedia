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
    //TextView textView;
    UserData userData;
    RecyclerView recyclerView;
    String title, body,ideaId;
    int textviewcount;
    List<UserIdea> listideas;
    ImageButton back;
    MainActivity mainActivity;

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






mainActivity=(MainActivity)getActivity();
        assert mainActivity != null;
        mainActivity.setUpIdeaList();


        back=binding.buttonBackMyIdeasPg;

        adapter = new ButtonWithTitleAdapter(this.getContext(),mainActivity.userIdeasViewModelArrayList, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tittle=getArguments().getString("A");
back.setOnClickListener(view1 -> replaceFragment(new InspirationPg()));

        //textView.setText(tittle);
    }

    @Override
    public void onButtonClick(int position, String title, String body, String ideaId) {
replaceFragment(new AddUserIdeaPg(title,body,ideaId));
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