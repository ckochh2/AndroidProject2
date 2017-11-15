package com.charukochhar.cs478.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

public class ListDealers extends Activity {

    // Initialize Car Dealers

    String[] listDealersAlto = {"Greater Chicago Motors" + "\n" + "1850 N Elston Ave, Chicago, IL 60642",
            "Windy City Motors" +"\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "Rogers Auto Group Chicago" + "\n" + "2720 S Michigan Ave, Chicago, IL 60616"
    };
    String[] listDealersAudi = {"McGrath Acura of Downtown Chicago" + "\n" + "1301 N Elston Ave, Chicago, IL 60642",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersBaleno = {"Howard Orloff Volvo Cars" + "\n" + "1924 N Paulina St, Chicago, IL 60622",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersBmw = {"Perillo BMW" + "\n" + "1035 N Clark St, Chicago, IL 60610",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersChervolet = {"Mancuso Motorsports" + "\n" + "677 N Clark St, Chicago, IL 60654",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersFerrari = {"Bentley Gold Coast " + "\n" + "834 N Rush St, Chicago, IL 60611",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersHondaCity = {"McGrath Acura of Downtown Chicago" + "\n" + "1301 N Elston Ave, Chicago, IL 60642",
            "Enterprise Car Sales" + "\n" + "3840 N Western Ave, Chicago, IL 60618",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersSwift = {"S & M Auto Sales" + "\n" + "4301 S Kedzie Ave, Chicago, IL 60632",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };
    String[] listDealersWagonR = {"Fox Ford Lincoln" + "\n" + "2501 N Elston Ave, Chicago, IL 60647",
            "Windy City Motors" + "\n" + "2662 N Cicero Ave, Chicago, IL 60639",
            "World Discount Auto" + "\n" + "800 S Western Ave, Chicago, IL 60612"
    };

    // Function to fetch Array String of Car Dealers
    public String[] getDealers(int thumbnailPos)
    {
        if(thumbnailPos==0)
            return listDealersAlto;
        else if(thumbnailPos==1)
            return listDealersAudi;
        else if(thumbnailPos==2)
            return listDealersBaleno;
        else if(thumbnailPos==3)
            return listDealersBmw;
        else if(thumbnailPos==4)
            return listDealersChervolet;
        else if(thumbnailPos==5)
            return listDealersFerrari;
        else if(thumbnailPos==6)
            return listDealersHondaCity;
        else if(thumbnailPos==7)
            return listDealersSwift;
        else if(thumbnailPos==8)
            return listDealersWagonR;
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dealers);
    // Get the car position from the main activity to show respective car dealers
        Intent i= getIntent();
        int thumbnailPos = i.getIntExtra(MainActivity.EXTRA_RESULT_CARNAME,0);

        // Create list of Items
        String[] listDealers = getDealers(thumbnailPos);

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listview,listDealers);

        // Configure the List View

        ListView listView = (ListView) findViewById(R.id.dealers_list);
        listView.setAdapter(adapter);

    }
}
