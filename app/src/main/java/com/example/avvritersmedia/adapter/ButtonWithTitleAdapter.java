package com.example.avvritersmedia.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avvritersmedia.R;
import com.example.avvritersmedia.usersdata.UserIdea;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;
import java.util.List;

public class ButtonWithTitleAdapter extends RecyclerView.Adapter<ButtonWithTitleAdapter.ViewHolder> {
    Context context;
    static ArrayList<UserIdea> arrayList;
    static ButtonClickListener buttonClickListener;
    public ButtonWithTitleAdapter(Context context, ArrayList<UserIdea> userIdeaArrayList,ButtonClickListener buttonClickListener)
    {
        this.context=context;
                ButtonWithTitleAdapter.buttonClickListener = buttonClickListener;
        arrayList=userIdeaArrayList;
    }
    @NonNull
    @Override
    public ButtonWithTitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.fragment_list_of_user_ideas_layout,parent,false);
        return new ButtonWithTitleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonWithTitleAdapter.ViewHolder holder, int position) {
holder.title.setText(arrayList.get(position).getTitle());
holder.layout.setText(arrayList.get(position).getIdeaId());
    }
    public interface ButtonClickListener {
        void onButtonClick(int position, String title, String body, String ideaId);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
public static class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title, layout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageButton_edit);
        title = itemView.findViewById(R.id.textView_titleholder);
        layout = itemView.findViewById(R.id.textView_backgroud);
        imageView.setOnClickListener(v -> {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && buttonClickListener != null) {

                UserIdea currentIdea = arrayList.get(position);
                buttonClickListener.onButtonClick(
                        position,
                        currentIdea.getTitle(),
                        currentIdea.getBody(),
                        currentIdea.getIdeaId()
                );
            }
        });
    }
}

//    private List<UserIdea> ideas;
//    private ButtonClickListener buttonClickListener;
//    private Context context;
//private int textViewCount;
//    public interface ButtonClickListener {
//        void onButtonClick(String title, String body,String id);
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageButton button;
//        private TextView titleTextView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            button = itemView.findViewById(R.id.imageButton_edit);
//            titleTextView = itemView.findViewById(R.id.textView1);
//        }
//
//        public void bind(UserIdea idea) {
//            titleTextView.setText(idea.getTitle());
//            itemView.setOnClickListener(v -> {
//                if (buttonClickListener != null) {
//                    buttonClickListener.onButtonClick( idea.getTitle(), idea.getBody(),idea.getIdeaId());
//                }
//            });
//            // Set button click listener
//            button.setOnClickListener(v -> {
//                if (buttonClickListener != null) {
//
//                    buttonClickListener.onButtonClick( idea.getTitle(), idea.getBody(),idea.getIdeaId());
//                }
//            });
//        }
//    }

}
