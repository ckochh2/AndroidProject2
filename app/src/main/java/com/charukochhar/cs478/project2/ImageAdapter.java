package com.charukochhar.cs478.project2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    public final String[] car_name;
    public final int[] car_image;

    public ImageAdapter(Context c,String[] car_name,int[] car_image)
    {
        mContext =c;
        this.car_name=car_name;
        this.car_image=car_image;

    }

    public int getCount()
    {
        return car_image.length;
    }

    public Object getItem(int position)
    {
        return null;
    }
    public long getItemId(int position)
    {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            grid = new View(mContext);
            grid=inflater.inflate(R.layout.single_item,null);
            TextView textView = (TextView) grid.findViewById(R.id.car_name);
            ImageView imageView = (ImageView)grid.findViewById(R.id.car_image);
            // Reduce the image size
      /*      Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(),car_image[position]);
            Bitmap bm = Bitmap.createScaledBitmap(bmp,300,300,true);   */
            textView.setText(car_name[position]);
            imageView.setImageResource(car_image[position]);
            //  grid.setLayoutParams(new GridView.LayoutParams(300,300));
            // grid.setScaleType(grid.ScaleType.CENTER);
            grid.setPadding(5, 5, 5, 5);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}
