package com.example.asus.proto5phase3.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.proto5phase3.Database.Model.Trip;
import com.example.asus.proto5phase3.R;


public abstract class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";



    private Trip[] mDataSet;
    public CustomAdapter(Trip[] dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewDest;
        public TextView textViewStart;
        public TextView textViewPrice;
        public ImageView imageViewProfile;

        public ViewHolder(View v) {
            super(v);
            textViewName = v.findViewById(R.id.them_name);
            textViewStart = v.findViewById(R.id.start);
            textViewDest = v.findViewById(R.id.dest);
             textViewPrice=v.findViewById(R.id.price);
            imageViewProfile=v.findViewById(R.id.profile);        }

        }
        // END_INCLUDE(recyclerViewSampleViewHolder)



        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view.
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.search_item, viewGroup, false);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "salam", Toast.LENGTH_SHORT).show();
                }
            });
            return new ViewHolder(v);
        }
        // END_INCLUDE(recyclerViewOnCreateViewHolder)

        // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.textViewName.setText(CustomAdapter.mDataSet[position].getId());
            viewHolder.textViewStart.setText(mDataSet[position].getOrigin());
            viewHolder.textViewDest.setText(mDataSet[position].getDestination());
        viewHolder.textViewPrice.setText(mDataSet[position].);
        viewHolder.imageViewProfile.setImageDrawable(mDataSet[position].profile);

        }
        // END_INCLUDE(recyclerViewOnBindViewHolder)

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataSet.length;
        }
    }
}


