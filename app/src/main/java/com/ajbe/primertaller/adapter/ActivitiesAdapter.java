package com.ajbe.primertaller.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ajbe.primertaller.R;

/**
 * Created by HP on 3/11/2017. For UAC
 */
public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {

    private final TypedArray mImages;

    public ActivitiesAdapter(Context context) {
        mImages = context.getResources().obtainTypedArray(R.array.icons);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_recycler_activities, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(mImages.getDrawable(position));
    }

    @Override
    public int getItemCount() {
        return mImages.length();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_image_icon);
        }

    }
}
