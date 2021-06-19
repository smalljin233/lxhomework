package com.example.androidhomework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DinarysAdapter extends RecyclerView.Adapter<DinarysAdapter.ViewHolder> {
    private ArrayList<Dinary> mDinaryData;
    private Context mContext;

    DinarysAdapter(Context context,ArrayList<Dinary> dianrysData){
        mContext = context;
        mDinaryData = dianrysData;
        mDinaryData = dianrysData;
    }

    @Override
    public DinarysAdapter.ViewHolder onCreateViewHolder(
            @NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(
            @NonNull @org.jetbrains.annotations.NotNull DinarysAdapter.ViewHolder holder, int position) {
        Dinary currentDinary =mDinaryData.get(position);
        holder.bindTo(currentDinary);
    }

    @Override
    public int getItemCount() {
        return mDinaryData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mDinaryImage;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.title_item);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle_item);
            mDinaryImage = itemView.findViewById(R.id.dinaryImage);
            itemView.setOnClickListener(this);
        }

        public void bindTo(Dinary currentDinary){
            mTitleText.setText(currentDinary.getTitle());
            mInfoText.setText(currentDinary.getMiniInfo());
            Glide.with(mContext).load(currentDinary.getImageResource()).into(mDinaryImage);
        }

        @Override
        public void onClick(View v) {
            Dinary dinary = mDinaryData.get(getAdapterPosition());
            Intent intent = new Intent(mContext,writeMyDinary.class);
            intent.putExtra("txtName",dinary.getTitle());
            mContext.startActivity(intent);

        }
    }

}
