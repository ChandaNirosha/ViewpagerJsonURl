package com.example.sys9.jsonserver2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class BookBD extends BaseAdapter {
    Context context;
    List<BookGS> bookGSList;

    public BookBD(Context context, List<BookGS> bookGSList) {

        this.context = context;
        this.bookGSList = bookGSList;

    }

    @Override
    public int getCount() {
        return bookGSList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View cview = LayoutInflater.from(context).inflate(R.layout.text, viewGroup, false);
        TextView name = cview.findViewById(R.id.id);
        name.setText(bookGSList.get(i).getId());

        TextView name2 = cview.findViewById(R.id.name);
        name2.setText(bookGSList.get(i).getName());

        TextView name3 = cview.findViewById(R.id.email);
        name3.setText(bookGSList.get(i).getEmail());

        TextView name4 = cview.findViewById(R.id.address);
        name4.setText(bookGSList.get(i).getAddress());

        TextView name5 = cview.findViewById(R.id.gender);
        name5.setText(bookGSList.get(i).getGender());

        TextView name6 = cview.findViewById(R.id.home);
        name6.setText(bookGSList.get(i).getHome());

        TextView name7 = cview.findViewById(R.id.office);
        name7.setText(bookGSList.get(i).getOffice());

        TextView name8 = cview.findViewById(R.id.mobile);
        name8.setText(bookGSList.get(i).getMobile());
        //name8.setText(bookGSList.get(i).getGender());


        view = cview;


        return view;
    }

}
