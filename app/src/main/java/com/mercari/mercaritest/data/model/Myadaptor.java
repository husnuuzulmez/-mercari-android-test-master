package com.mercari.mercaritest.data.model;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercari.mercaritest.R;

public class Myadaptor extends ArrayAdapter<Item> {
    ArrayList<Item> actorList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public Myadaptor(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        actorList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design

        View v = convertView;
        if (v == null) {

            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.imageview = (ImageView) v.findViewById(R.id.ivImage);
            holder.imageviewSold = (ImageView) v.findViewById(R.id.ivImagesold);
            holder.tvName = (TextView) v.findViewById(R.id.tvName);
            holder.tvPrice = (TextView) v.findViewById(R.id.tvPrice);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        new DownloadImageTask(holder.imageview).execute(actorList.get(position).photo);
        holder.tvName.setText(actorList.get(position).name);
        holder.tvPrice.setText("$"+ Long.toString(actorList.get(position).price));
        if ( actorList.get(position).status.equals("sold_out") )

        holder.imageviewSold.setImageResource(R.drawable.sold);
        return v;

    }

    static class ViewHolder {
        public ImageView imageview;
        public ImageView imageviewSold;
        public TextView tvName;
        public TextView tvPrice;



    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];


            urldisplay = urldisplay.substring(0, 4) + "s" + urldisplay.substring(4, urldisplay.length());
            Log.d("MyTagGoesHere", urldisplay);

            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}