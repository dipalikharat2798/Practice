package com.geico.adexpress.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.geico.adexpress.R;
import com.geico.adexpress.activity.FormsSecondActivity;
import com.geico.adexpress.model.FormsMainListModel;

import java.util.ArrayList;

public class FormsMainAdapter extends RecyclerView.Adapter<FormsMainAdapter.MyviewHolder> {
    private Activity mContext;
    private Class mContext1;
    private ArrayList<FormsMainListModel> usersList;
    public FormsMainAdapter(Activity mContext,Class mContext1, ArrayList<FormsMainListModel> usersList) {
        this.mContext = mContext;
        this.usersList = usersList;
        this.mContext1=mContext1;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.formsmainlist, parent, false);
        return new FormsMainAdapter.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        FormsMainListModel pojo=usersList.get(position);
        holder.forms_name.setText(pojo.getForm_name());
        String name = pojo.getForm_name();
        holder.forms_main_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, mContext1);
                intent.putExtra("FormsMainNode",name);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{
        TextView forms_name;
        CardView forms_main_cv;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            forms_name=itemView.findViewById(R.id.mainformsname_tv);
            forms_main_cv=itemView.findViewById(R.id.forms_main_cv);
        }
    }
}
