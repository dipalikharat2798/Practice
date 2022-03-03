package com.example.equivalent.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.equivalent.model.CallLogModel;
import com.example.equivalent.R;

import java.util.ArrayList;

public class CallLogAdapter extends RecyclerView.Adapter<CallLogAdapter.MyViewHolder> implements Filterable {
    private int px;
    Context context;
    ArrayList<CallLogModel> callLogModelArrayList;
    private  ArrayList<CallLogModel>  exampleListFull;

    public CallLogAdapter(Context context, ArrayList<CallLogModel> callLogModelArrayList) {
        this.context = context;
        this.callLogModelArrayList = callLogModelArrayList;
        exampleListFull = new ArrayList<>(callLogModelArrayList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Resources r = parent.getResources();
        px = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 8,r.getDisplayMetrics()));
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int i = position;
        if(i == 0){
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
            layoutParams.topMargin = px;
            holder.cardView.requestLayout();
        }

        CallLogModel currentLog = callLogModelArrayList.get(position);
        holder.tv_ph_num.setText(currentLog.getPhNumber()+" "+currentLog.getCallTime());
        holder.tv_contact_name.setText(currentLog.getContactName());
//        holder.tv_call_type.setText(currentLog.getCallType());
//        holder.tv_call_date.setText(currentLog.getCallDate());
//        holder.tv_call_time.setText(currentLog.getCallTime());
//        holder.tv_call_duration.setText(currentLog.getCallDuration());
    }

    @Override
    public int getItemCount() {
        return callLogModelArrayList==null ? 0 : callLogModelArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<CallLogModel> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (CallLogModel item : exampleListFull) {
                    if (item.getContactName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleListFull.clear();
            exampleListFull.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tv_ph_num, tv_contact_name;
               //tv_call_type, tv_call_date, tv_call_time, tv_call_duration;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ph_num = itemView.findViewById(R.id.details);
            tv_contact_name = itemView.findViewById(R.id.name);
//            tv_call_type = itemView.findViewById(R.id.layout_call_log_type);
//            tv_call_date = itemView.findViewById(R.id.layout_call_log_date);
//            tv_call_time = itemView.findViewById(R.id.layout_call_log_time);
//            tv_call_duration = itemView.findViewById(R.id.layout_call_log_duration);
            cardView = itemView.findViewById(R.id.card1);
        }
    }

}
