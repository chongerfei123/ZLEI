package com.example.zl.zlei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by zl on 2017/5/9.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {

    Context context;
    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = new TextView(context);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        holder.textView.setText("sdfghj");
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
class HomeHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public HomeHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}