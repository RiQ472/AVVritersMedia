package com.example.avvritersmedia.utils;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.avvritersmedia.MainActivity;
import com.example.avvritersmedia.usermodel.UserDataViewModel;
import com.example.avvritersmedia.usersdata.UserData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class FirebaseUtil {
    static UserDataViewModel userDataViewModel;
    static MainActivity mainActivity;
    public FirebaseUtil(MainActivity mainActivity){
        this.mainActivity=mainActivity;
        UserDataViewModel.getUserData().getValue();

    }
    public static String currentUserId(){

        return Objects.requireNonNull(UserDataViewModel.getUserData().getValue()).getUserId();
    }

    public static boolean isLoggedIn(){
        if(currentUserId()!=null){
            return true;
        }
        return false;
    }

public static void saveUserDataCollection()
{
    if (isLoggedIn()) {
UserData user= UserDataViewModel.getUserData().getValue();
        // Save the user data to Firestore in a "users" collection
        FirebaseFirestore.getInstance().collection("users")  // "users" is the collection where we store user data
                .document(user.getUserId())  // Use the userId as the document ID
                .set(user.getDataList())  // The user object will be saved as a document in Firestore
                .addOnSuccessListener(aVoid -> {

                })
                .addOnFailureListener(e -> {
                    // Failed to save user data
                });
    }
}
public static void getUserDataViewModel()
{
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("users").child(currentUserId());

}
    public static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("users").document(currentUserId());
    }

    public static CollectionReference allUserCollectionReference(){
        return FirebaseFirestore.getInstance().collection("users");
    }



    public static DocumentReference getIdeasReference(String uid){

        return FirebaseFirestore.getInstance().collection("Users").document(currentUserId()).collection("ideas").document(uid);
    }
    public static CollectionReference getAllIdeaReferences(){

        return FirebaseFirestore.getInstance().collection("Users").document(currentUserId()).collection("ideas");
    }



//    public static void logout(){
//        FirebaseAuth.getInstance().signOut();
//    }
//
//    public static DocumentReference getChatroomReference(String chatroomId){
//        return FirebaseFirestore.getInstance().collection("chatrooms").document(chatroomId);
//    }
//    public static String getChatroomId(String userId1,String userId2){
//        if(userId1.hashCode()<userId2.hashCode()){
//            return userId1+"_"+userId2;
//        }else{
//            return userId2+"_"+userId1;
//        }
//    }
//
//    public static CollectionReference allChatroomCollectionReference(){
//        return FirebaseFirestore.getInstance().collection("chatrooms");
//    }
//
//    public static DocumentReference getOtherUserFromChatroom(List<String> userIds){
//        if(userIds.get(0).equals(FirebaseUtil.currentUserId())){
//            return allUserCollectionReference().document(userIds.get(1));
//        }else{
//            return allUserCollectionReference().document(userIds.get(0));
//        }
//    }
//
//    public static String timestampToString(Timestamp timestamp){
//        return new SimpleDateFormat("HH:MM").format(timestamp.toDate());
//    }
//    public static StorageReference  getCurrentProfilePicStorageRef(){
//        return FirebaseStorage.getInstance().getReference().child("profile_pic")
//                .child(FirebaseUtil.currentUserId());
//    }
//
//    public static StorageReference  getOtherProfilePicStorageRef(String otherUserId){
//        return FirebaseStorage.getInstance().getReference().child("profile_pic")
//                .child(otherUserId);
//    }

}

