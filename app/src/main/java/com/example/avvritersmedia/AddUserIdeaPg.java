package com.example.avvritersmedia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.avvritersmedia.databinding.FragmentAddUserIdeaPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.usersdata.UserIdea;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddUserIdeaPg extends Fragment {

Button back;
Button save;
EditText title;
EditText body;
    FragmentAddUserIdeaPgBinding binding;
    FirebaseFirestore db;
    MainActivity mainActivity;
UserDataViewModel userDataViewModel;
String t;
String b;
String Id;
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
        back=binding.buttonBackAuipg;
        save=binding.buttonSave;
        title=binding.edittextUserIdeaTitle;
        body=binding.edittextUserIdeaBody;
        mainActivity=(MainActivity) getActivity();
        userDataViewModel=new ViewModelProvider(requireActivity()).get(UserDataViewModel.class);
        if(edit){title.setText(t);body.setText(b);}
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back.setOnClickListener(view1 -> replaceFragment(new InsparationPg()));
save.setOnClickListener(view1 ->
     {
         String t=title.getText().toString();
         String b=body.getText().toString();
         if(t.isEmpty())title.setError("A tittle is needed");
mainActivity.updateUserData("useridea",t+','+b);
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