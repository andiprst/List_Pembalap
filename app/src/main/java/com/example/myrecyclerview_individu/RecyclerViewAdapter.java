package com.example.myrecyclerview_individu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> ImageNames = new ArrayList<>();
    private ArrayList<String> Images = new ArrayList<>();
    private ArrayList<String> ImageDes = new ArrayList<>();
    private Context Context;

    public RecyclerViewAdapter(android.content.Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> imageDes) {
        ImageNames = imageNames;
        Images = images;
        ImageDes = imageDes;
        Context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(Context)
                .asBitmap()
                .load(Images.get(position))
                .into(holder.image);

        holder.imageName.setText(ImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + ImageNames.get(position));

                Toast.makeText(Context, ImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Context, GalleryActivity.class);
                intent.putExtra("image_url", Images.get(position));
                intent.putExtra("image_name", ImageNames.get(position));
                intent.putExtra("image_des", ImageDes.get(position));
                Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
