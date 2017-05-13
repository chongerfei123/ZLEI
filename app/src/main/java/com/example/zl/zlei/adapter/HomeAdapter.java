package com.example.zl.zlei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zl.zlei.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by zl on 2017/5/9.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {


    Context context;
    ArrayList<String> historyData;
    OnItemClickListener onItemClickListener;
    public HomeAdapter(Context context, ArrayList<String> historyData) {
        this.context = context;
        this.historyData = historyData;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TextView view = new TextView(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_history_recyc,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        holder.textView.setText(historyData.get(position));
    }

    @Override
    public int getItemCount() {
        return historyData.size();
    }


    class HomeHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public HomeHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.his_item_text);

            if (onItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItenClick(v,getPosition());
                    }
                });
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemClickListener.onItenLongClick(v,getPosition());
                        return true;
                    }
                });
            }

        }
    }

    public interface OnItemClickListener{
        void onItenClick(View view,int position);
        void onItenLongClick(View view,int position);
    }
}
