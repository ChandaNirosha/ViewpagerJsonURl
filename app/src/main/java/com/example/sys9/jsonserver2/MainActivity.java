package com.example.sys9.jsonserver2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
    MyCustomPagerAdapter myCustomPagerAdapter;
    ProgressDialog mProgressDialog;
    private ListView listView;
    private List<BookGS> bookGS;
    private ListView llChb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);



             listView = findViewById(R.id.list);
        String url = "https://api.androidhive.info/contacts/";
        new ResponseAsync().execute(url);


    }

    private class ResponseAsync extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("get response Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(String... url) {
            String respURL = url[0];

            try {
                // Download Image from URL

                URL ur = new URL(respURL);
                InputStream is = ur.openConnection().getInputStream();

                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }


                return buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            List<BookGS> bookGSList = new ArrayList<>();

            try {
                Log.i("***************", s);
                JSONObject root_object = new JSONObject(s);

                JSONArray contacts_array = root_object.getJSONArray("contacts");
                for (int i = 0; i < contacts_array.length(); i++) {


                    JSONObject list_obj = contacts_array.getJSONObject(i);

                    BookGS item = new BookGS();
                    item.setId(list_obj.getString("id"));
                    item.setName(list_obj.getString("name"));
                    item.setEmail(list_obj.getString("email"));
                    item.setAddress(list_obj.getString("address"));
                    item.setGender(list_obj.getString("gender"));

                    JSONObject phone_obj = list_obj.getJSONObject("phone");

                    item.setMobile(phone_obj.getString("mobile"));
                    item.setHome(phone_obj.getString("home"));
                    item.setOffice(phone_obj.getString("office"));


                    bookGSList.add(item);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BookBD myAdapter1 = new BookBD(getApplicationContext(), bookGSList);
            listView.setAdapter(myAdapter1);

            //progressBar.setVisibility(View.GONE);
            mProgressDialog.dismiss();
        }
    }
}