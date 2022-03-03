package com.geico.adexpress.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.geico.adexpress.R;
import com.geico.adexpress.model.FirebaseUserDetailsPojo;

import java.util.ArrayList;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.MyViewHolder> {

    private Activity mContext;
    private ArrayList<FirebaseUserDetailsPojo> usersList;
    public ArrayList<FirebaseUserDetailsPojo> selectedUsersList = new ArrayList<>();


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username_tv, ucode_tv, deviceName_tv, os_version_tv, lastLogin_tv;
        public LinearLayout users_rv_row;
        CheckBox user_select_cb;

        public MyViewHolder(View view) {
            super(view);
            username_tv = (TextView) view.findViewById(R.id.firebase_uname_tv);
            ucode_tv = (TextView) view.findViewById(R.id.firebase_ucode_tv);
            deviceName_tv = (TextView) view.findViewById(R.id.firebase_devicename_value_tv);
            os_version_tv = (TextView) view.findViewById(R.id.firebase_os_version_value_tv);
            lastLogin_tv = (TextView) view.findViewById(R.id.firebase_users_calender_tv);
            users_rv_row = (LinearLayout) view.findViewById(R.id.users_rv_row);

            user_select_cb = (CheckBox) view.findViewById(R.id.user_select_cb);
        }
    }

    public UsersListAdapter(Activity mContext, ArrayList<FirebaseUserDetailsPojo> usersList) {
        this.mContext = mContext;
        this.usersList = usersList;
    }

    public void updateListData(ArrayList<FirebaseUserDetailsPojo> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        FirebaseUserDetailsPojo pojo = usersList.get(position);
        holder.username_tv.setText(pojo.USER_NAME);
        holder.ucode_tv.setText(pojo.USERID);
        holder.deviceName_tv.setText(pojo.DEVICE_BRAND_MODEL);
        holder.os_version_tv.setText(pojo.OS_VERSION);
        holder.lastLogin_tv.setText("Last Action : " + pojo.LAST_ACTION);

        holder.user_select_cb.setOnCheckedChangeListener(null);
        if (selectedUsersList.contains(pojo)) {
            holder.user_select_cb.setChecked(true);
        } else {
            holder.user_select_cb.setChecked(false);
        }
        holder.user_select_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!selectedUsersList.contains(pojo)) {
                        selectedUsersList.add(pojo);
                    }
                } else {
                    if (selectedUsersList.contains(pojo)) {
                        selectedUsersList.remove(pojo);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}