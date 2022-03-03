package com.example.billbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.billbook.DatabaseHelper.DatabaseHelper;
import com.example.billbook.MainActivity;
import com.example.billbook.Model.BillModel;
import com.example.billbook.R;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.MyViewHolder> {
    private List<BillModel> modelList;
    private MainActivity activity;
    private DatabaseHelper myDB;

    public BillAdapter(List<BillModel> modelList, MainActivity activity) {
        this.modelList = modelList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final BillModel item = modelList.get(position);
        holder.billname.setText(item.getBillName());
        holder.billnumber.setText(item.getBillNumber());
        holder.category.setText(item.getCategary());
        holder.amtpaid.setText(item.getAmountpaid());
        holder.date.setText(item.getDate());
        holder.status.setText(item.getSatus());
    }
    public Context getContext(){
        return activity;
    }
    public void setTask(List<BillModel> mlist){
        this.modelList=mlist;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView billname,billnumber,category,amtpaid,date,status;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            billname=itemView.findViewById(R.id.billname);
            billnumber=itemView.findViewById(R.id.billnumber);
            category=itemView.findViewById(R.id.category);
            amtpaid=itemView.findViewById(R.id.amtpaid);
            date=itemView.findViewById(R.id.date);
            status=itemView.findViewById(R.id.status);
        }
    }
}
