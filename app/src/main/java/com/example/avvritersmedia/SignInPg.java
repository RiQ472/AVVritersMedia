package com.example.avvritersmedia;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.avvritersmedia.databinding.FragmentSignInPgBinding;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.example.avvritersmedia.utils.FirebaseUtil;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SignInPg extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
UserData userData;
EditText username;
EditText email;
EditText password;
Button signin;
FragmentSignInPgBinding binding;
    public SignInPg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SignIn.
     */
    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSignInPgBinding.inflate(inflater, container, false);
        username=binding.editTextUsername;
        email=binding.editTextEmail;
        password=binding.editTextPassword;
        signin=binding.buttonSign;

        return binding.getRoot();
    }
    @SuppressLint("RestrictedApi")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signin.setOnClickListener(view1 -> {
String em=email.getText().toString();
            String un=username.getText().toString();
            String pass=password.getText().toString();
            if(em.isEmpty()){email.setError("Pleas fill in field"); return;}
            if(un.isEmpty()){username.setError("Pleas fill in field");return;}
           if(pass.isEmpty()){password.setError("Pleas fill in field");return;}
            userData=new UserData();
           userData.setUserId("user_Test");//+createUserId());
           userData.setPassword(pass);
           userData.setUserEmail(em);
           userData.setUserName(un);

           UserDataViewModel.setUserData(userData);
            FirebaseUtil.saveUserDataCollection();

           replaceFragment(new InspirationPg());
        });
    }
    String createUserId()
    {
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
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