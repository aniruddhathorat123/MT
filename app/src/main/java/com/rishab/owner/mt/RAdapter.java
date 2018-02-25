package com.rishab.owner.mt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OWNER on 03-03-2016.
 */
public class RAdapter extends ArrayAdapter {

    List list=new ArrayList();

    public RAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RContacts object) {
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ContactHolder contactHolder;

        if(row==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.rlayout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tx_name=(TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_number=(TextView)row.findViewById(R.id.tx_number);
            contactHolder.tx_actArrival=(TextView)row.findViewById(R.id.tx_arrival);
            contactHolder.tx_actDep=(TextView)row.findViewById(R.id.tx_dep);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder)row.getTag();
        }

        RContacts contacts=(RContacts)this.getItem(position);
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_number.setText(contacts.getNumber());
        contactHolder.tx_actArrival.setText(contacts.getActarr());
        contactHolder.tx_actDep.setText(contacts.getActdep());
        return row;
    }
    static class ContactHolder
    {
        TextView tx_name,tx_number,tx_actArrival,tx_actDep;
    }
}
