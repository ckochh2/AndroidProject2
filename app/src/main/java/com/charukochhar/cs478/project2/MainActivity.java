package com.charukochhar.cs478.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    protected static final String EXTRA_RES_ID="POS";
    protected static final String EXTRA_RESULT = "POS1";
    protected static final String EXTRA_RESULT_CARNAME ="POS2";

    // Initialize the Grid View for Car images
    GridView gridView;
    // Initialize the Car Name
    String[] car_name = {"alto","audi","baleno","bmw","chevrolet","ferrari","honda city","swift","wagonR"};
    // Initialize the Car Image layout id
    int[] car_image = {
            R.drawable.alto,R.drawable.audi,R.drawable.baleno,
            R.drawable.bmw,R.drawable.chevrolet,R.drawable.ferrari,
            R.drawable.honda_city,R.drawable.swift,R.drawable.wagon_r
    };
    // Initialize the website for the Cars
    String[] car_website = {"https://www.marutisuzuki.com/alto800.aspx","https://www.audiusa.com/",
            "http://baleno.co.in/","https://www.bmwusa.com/",
            "http://www.chevrolet.com/","https://www.ferrari.com/en-US",
            "http://www.honda.com/","https://www.marutisuzuki.com/swift.aspx",
            "https://www.marutisuzuki.com/wagonr.aspx"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the adapter
        ImageAdapter adapter = new ImageAdapter(MainActivity.this,car_name,car_image);

        gridView = (GridView)findViewById(R.id.griedview);
        gridView.setAdapter(adapter);
        // OnClick Code to Open Image in a new window
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            public void onItemClick(AdapterView<?> parent,View v,int position,long id)
                                            {
                                                Intent i = new Intent(getApplicationContext(),Open_Image.class);
                                                i.putExtra(EXTRA_RES_ID,car_image[position]);
                                                i.putExtra(EXTRA_RESULT,car_website[position]);
                                                startActivity(i);
                                            }
                                        }
        );

        // Register the View
        registerForContextMenu(gridView);
    }

    //Implement the onCreateContextMenu() method in your Activity
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo)
        {
            super.onCreateContextMenu(menu,v,menuInfo);
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.car_context_menu,menu);
        }

    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.viewpicture:              // Context Menu First Option to View Car Image
                Intent intent1 = new Intent(getApplicationContext(),Open_Image.class);
                intent1.putExtra(EXTRA_RES_ID,car_image[info.position]);
                startActivity(intent1);
                return true;
            case R.id.seewebsite:               // Context Menu Second Option to View Car Website
                Intent intent2 = new Intent( );
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse(car_website[info.position]));
                startActivity(intent2);
                return true;
            case R.id.listdealers:              // Context Menu Third Option to View the List of Car Dealers
                Intent intent3 = new Intent(getApplicationContext(),ListDealers.class);
                intent3.putExtra(EXTRA_RESULT_CARNAME,info.position);
                startActivity(intent3);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
