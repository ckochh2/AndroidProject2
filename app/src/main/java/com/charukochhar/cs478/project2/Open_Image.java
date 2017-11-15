package com.charukochhar.cs478.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import static com.charukochhar.cs478.project2.MainActivity.EXTRA_RES_ID;

public class Open_Image extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open__image);
        Intent i;
        // Get Intent Extra Value passing Car Image from Main Activity
        i = getIntent();
        // Set Image View to display the Image from main activity
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(i.getIntExtra(EXTRA_RES_ID,0));
        setContentView(imageView);
        // Get Intent Extra Value passing Car Website from Main Activity
        final String website = i.getStringExtra(MainActivity.EXTRA_RESULT);


        //On Click of Image -- open website
        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(website));
                startActivity(intent);

            }
        });
    }
}
