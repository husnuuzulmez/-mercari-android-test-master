package com.mercari.mercaritest;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.data.model.Myadaptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aaaa();
    }

    public String loadJSONFromAsset( ) {
        String json = null;

        Log.d("MyTagGoesHere", "Iki");
            AssetManager assetManager = getAssets();
        try {
            Log.d("MyTagGoesHere", "Uc");
            InputStream is =  getAssets().open("all.json");
            Log.d("MyTagGoesHere", "Dort");
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

            Log.d("MyTagGoesHere", "Bes");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;




    }


    public void aaaa()
    {

        GridView list=(GridView) findViewById(R.id.L1);
  //      ArrayList<actors> actorsList;
        ArrayList<Item> countryList = new ArrayList<Item>();

   //     ListAdapter adapter;
        Myadaptor adapter;
        JSONObject obj = null;
        JSONObject jsonObject=null;

        Log.d("MyTagGoesHere", "Bir");

        try {
            obj = new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("MyTagGoesHere", "Alti");
        JSONArray data= null;
        try {
            data = obj.getJSONArray("data");

        int s=data.length();




            Log.d("MyTagGoesHere", "yedi");
          for (int i = 0; i<s; i++){
             jsonObject=data.getJSONObject(i);
            String id=jsonObject.getString("id");
            String name=jsonObject.getString("name");
            String status=jsonObject.getString("status");
            long num_likes=jsonObject.getLong("num_likes");
            long num_comments=jsonObject.getLong("num_comments");
            long price=jsonObject.getLong("price");
            String photo=jsonObject.getString("photo");
              Log.d("MyTagGoesHere", "Sekiz");
             countryList.add(new Item(id,name,num_likes,num_comments,price,photo,status));
              Log.d("MyTagGoesHere", "Sekiz  bucuk ");
        }




       //     adapter = new Adapter(NoticeBoard.this, title_array, notice_array);
        //    list.setAdapter(adapter);
            adapter = new Myadaptor(getApplicationContext(), R.layout.row,
                    countryList);

            list.setAdapter(adapter);


            // f=(TextView) findViewById(R.id.textTuh);
            // f.setText(title_array);
        } catch (JSONException e) {
            Log.d("MyTagGoesHere", "HATAAAAAAA");
            // TODO Auto-generated catch block
            e.printStackTrace();

            // tv.setText("error2")


        }
    }
}
