package com.rishab.owner.mt;

/**
 * Created by OWNER on 19-02-2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OWNER on 16-01-2016.
 */
public class ContactAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ContactAdapter(Context context, int resource)
    {
        super(context, resource);
    }


    public void add(Contacts object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row == null)
        {
            //how to recreate that row
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_layout,parent,false);//inflate that layout,and save that one to row..
            //initialise particular variable on static class..
            contactHolder = new ContactHolder();
            contactHolder.tx_name =(TextView) row.findViewById(R.id.tx_name);
            contactHolder.tx_review =(TextView) row.findViewById(R.id.tx_review);

            row.setTag(contactHolder);

        }

        //if row is already available
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        //how to set the resource for the textview...
        Contacts contacts =(Contacts) this.getItem(position);
        //set resource for contact holder...
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_review.setText(contacts.getReview());

        return row;
    }
    static class ContactHolder
    {
        TextView tx_name,tx_review;
    }
}


