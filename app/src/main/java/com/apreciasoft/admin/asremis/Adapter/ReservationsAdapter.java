package com.apreciasoft.admin.asremis.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.apreciasoft.admin.asremis.Entity.InfoTravelEntity;
import com.apreciasoft.admin.asremis.Fracments.ReservationsFrangment;
import com.apreciasoft.admin.asremis.R;
import com.apreciasoft.admin.asremis.Util.RecyclerViewClickListener;

import java.util.List;

/**
 * Created by usario on 25/4/2017.
 */


public class ReservationsAdapter
        extends RecyclerView.Adapter<ReservationsAdapter.MyViewHolder>  {

    private List<InfoTravelEntity> mDataset;
    private Context context;
    private static RecyclerViewClickListener itemListener;
    private Fragment fragment;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CardView mCardView;
        public TextView mTextView;
        public TextView mtv_blah;
        public TextView mtv_blah2;
        public TextView mtv_blah3;
        public ImageButton mImageButton;
        public MyViewHolder temObj = null;



        public MyViewHolder(View v) {
            super(v);

            temObj =  this;

            mCardView = (CardView) v.findViewById(R.id.car_notifications);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
            mtv_blah = (TextView) v.findViewById(R.id.tv_blah);
            mtv_blah2 = (TextView) v.findViewById(R.id.tv_blah2);
            mtv_blah3 = (TextView) v.findViewById(R.id.tv_blah3);
            mImageButton= (ImageButton) v.findViewById(R.id.imageButton);



        }



        @Override
        public void onClick(View v) {

        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public ReservationsAdapter(List<InfoTravelEntity> myDataset, Fragment fragment, Context context) {

        this.context = context;
        mDataset = myDataset;
        this.fragment = fragment;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ReservationsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_notifications, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset.get(position).getMdate());
        holder.mtv_blah.setText(mDataset.get(position).getNameOrigin());
        holder.mtv_blah2.setText(mDataset.get(position).getNameDestination());
        holder.mtv_blah3.setText(mDataset.get(position).getClient());

        if(mDataset.get(position).getIsAceptReservationByDriver() == 1)
        {
           holder.mImageButton.setEnabled(false);
        }

        holder.mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.mImageButton,position);
            }
        });

    }

    private void showPopupMenu(View view, final int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(view.getContext(),view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.rervations_option, popup.getMenu());
       // popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));


        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.opt_confirm:
                        // do what you need.
                        ((ReservationsFrangment)fragment).event_confirm(position);
                        break;
                    case R.id.opt_refush:
                        // do what you need .
                        ((ReservationsFrangment)fragment).event_cancel(position);
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

        popup.show();


    }




    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}