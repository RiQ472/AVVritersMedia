package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.example.avvritersmedia.databinding.FragmentAddUserIdeaPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.utils.FirebaseUtil;

public class AddUserIdeaPg extends Fragment {

ImageButton back, save;
EditText title;
EditText body;
    FragmentAddUserIdeaPgBinding binding;
UserDataViewModel userDataViewModel;
String t;
String b;
String Id;
ScrollView scrollView;
    UserData userData;
    MainActivity mainActivity;
boolean edit;
public AddUserIdeaPg(String t,String b,String Id){
    this.t=t;
    this.b=b;
    this.Id=Id;
    edit=true;
}
public AddUserIdeaPg(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAddUserIdeaPgBinding.inflate(inflater, container, false);
        back=binding.buttonBackUIpg;
        save=binding.buttonSave;
        title=binding.edittextUserIdeaTitle;
        body=binding.edittextUserIdeaBody;
        scrollView=binding.scrollviewBody;
        mainActivity=(MainActivity)getActivity();
userData=UserDataViewModel.getUserData().getValue();
        if(edit){title.setText(t);body.setText(b);}
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scrollView.setVerticalScrollBarEnabled(true);
        body.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Scroll to the bottom automatically
                body.post(new Runnable() {
                    @Override
                    public void run() {
                        // This will ensure the EditText scrolls to the bottom
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        back.setOnClickListener(view1 -> replaceFragment(new InspirationPg()));
        save.setOnClickListener(view1 ->
        {
            String t = title.getText().toString();
            String b = body.getText().toString();
            if (t.isEmpty()) title.setError("A tittle is needed");
FirebaseUtil.isLoggedIn();
            userData.addIdea(t,b);
            UserDataViewModel.setUserData(userData);
            FirebaseUtil.saveUserDataCollection();
            mainActivity.setUpIdeaList();
            replaceFragment(new UserIdeasPg());
        });
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