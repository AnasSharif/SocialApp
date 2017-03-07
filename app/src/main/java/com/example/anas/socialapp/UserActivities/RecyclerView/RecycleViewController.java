package com.example.anas.socialapp.UserActivities.RecyclerView;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anas.socialapp.ModalClasses.UserData;
import com.example.anas.socialapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anas on 3/7/17.
 */

public class RecycleViewController extends RecyclerView.Adapter<RecycleViewController.RCViewHolder> {

    List<UserData> list;
    public RecycleViewController(List<UserData> list ) {
       this.list = list;
    }

    @Override
    public RCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_layout,parent,false);

        return new RCViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RCViewHolder holder, int position) {
      UserData userData = list.get(position);
        holder.username.setText(userData.getUsername());
        holder.useremail.setText(userData.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RCViewHolder extends RecyclerView.ViewHolder{

        TextView username,useremail;
        public RCViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.rcusername_textView);
            useremail = (TextView) itemView.findViewById(R.id.rcuseremail_textView);
        }
    }
}
