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
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.avvritersmedia.databinding.FragmentUserIdeasPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.Map;

public class UserIdeasPg extends Fragment {


    FragmentUserIdeasPgBinding binding;
    //TextView textView;
    TextView rc;
ImageButton edit;
    MainActivity mainActivity;
    UserDataViewModel userDataViewModel;
    UserData userData;
    RelativeLayout relativeLayout;
    String title;
    String body;
    String IdeaId;
    int textviewcount;

    public UserIdeasPg() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserIdeasPgBinding.inflate(inflater, container, false);
        mainActivity = (MainActivity) getActivity();
        relativeLayout = binding.ideaListLayoutView;
        // Get the ViewModel
        edit=binding.imageButton;
        userDataViewModel = new ViewModelProvider(requireActivity()).get(UserDataViewModel.class);
        userData = userDataViewModel.getUserData().getValue();
        rc = binding.textView1;
        rc.setTextSize(34);
        textviewcount=10001;
        rc.setId(textviewcount);
        rc.setTextColor(R.color.black);
        if (userData != null && userData.getListOfIdeas() != null) {
            for (Map.Entry<String, UserIdea> entry : userData.getListOfIdeas().entrySet()) {
                if (rc.getText().toString().isEmpty()){;
                title=entry.getValue().getTitle();
                body=entry.getValue().getBody();
                    rc.setText(title);
                }
              //  else createTextView(entry.getValue().getTitle());
                textviewcount++;
            }
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tittle=getArguments().getString("A");
edit.setOnClickListener(view1 -> replaceFragment(new AddUserIdeaPg(title,body,IdeaId)));
    binding.buttonBackMyIdeasPg.setOnClickListener(view1 -> replaceFragment(new InsparationPg()));
        //textView.setText(tittle);
    }

    public void recylcleViewTittles() {

    }

    @SuppressLint("ResourceAsColor")
    public void createTextView(String t) {
        TextView textView = new TextView(this.getContext());
        ImageButton dhjfh;
        LayoutParams layoutParams1 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams1.addRule(RelativeLayout.BELOW, textviewcount-1);
        layoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //layoutParams1.height=66;
        //layoutParams1.width=383;
        textView.setLayoutParams(layoutParams1);
        textView.setHeight(66);
        textView.setWidth(393);
        textView.setText(t);
        textView.setTextSize(30);
        textView.setTextColor(getResources().getColor(R.color.black));
        //textView.setBackgroundResource(ContextCompat.getDrawable(getActivity(),R.drawable.common_google_signin_btn_text_light_normal));
        textView.setBackgroundColor(getResources().getColor(R.color.grey));
        textView.setId(textviewcount);

ImageButton button=new ImageButton(getActivity());

        relativeLayout.addView(textView);
//    textView.setBackgroundResource(R.drawable.common_google_signin_btn_text_light_normal);
//    Drawable drawable= new drawable("common_google_signin_btn_text_light_normal");
//    textView.setBackground(R.drawable("common_google_signin_btn_text_light_normal"));

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