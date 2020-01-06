package com.bzhong7.labs.dswopapp.Utils;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.bzhong7.labs.dswopapp.Chat.SelectConvoActivity;
import com.bzhong7.labs.dswopapp.ItemList.ItemListActivity;
import com.bzhong7.labs.dswopapp.Main.Add_Item_Activity;
import com.bzhong7.labs.dswopapp.Main.MainActivity;
import com.bzhong7.labs.dswopapp.Profile.Profile_Activity;
import com.bzhong7.labs.dswopapp.R;

/**
 * DatingApp
 * https://github.com/quintuslabs/DatingApp
 * Created on 25-sept-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class TopNavigationViewHelper {

    private static final String TAG = "TopNavigationViewHelper";

    public static void setupTopNavigationView(BottomNavigationViewEx tv) {
        Log.d(TAG, "setupTopNavigationView: setting up navigationview");


    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_profile:
                        Intent intent2 = new Intent(context, Profile_Activity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_main:
                        Intent intent1 = new Intent(context, MainActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_matched:
                        Intent intent3 = new Intent(context, SelectConvoActivity.class);
                        context.startActivity(intent3);

                        break;

                    case R.id.ic_add_item:
                        Intent intent4 = new Intent(context, Add_Item_Activity.class);
                        context.startActivity(intent4);

                        break;

                    case R.id.ic_collections_black_24dp:
                        Intent intent5 = new Intent(context, ItemListActivity.class);
                        context.startActivity(intent5);

                        break;
                }

                return false;
            }
        });
    }
}
