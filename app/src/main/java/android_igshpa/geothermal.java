package com.example.srivallikanchibotla.android_igshpa;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by maheshkumarkankipati on 1/27/17.
 */

public class geothermal extends Activity {

    String flag = "mainView";
    @Override
    public void onBackPressed() {
        if(flag == "resView" || flag =="comView") {
            Intent backButton = new Intent(getBaseContext(), geothermal.class);
            startActivity(backButton);
        }else {
            Intent backView = new Intent(getBaseContext(), Home.class);
            startActivity(backView);
        }
    }
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geothermal_main);
        flag = "mainView";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("Geothermal");
        Button res = (Button) findViewById(R.id.residential);
        Button com = (Button) findViewById(R.id.commercial);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "resView";
                setContentView(R.layout.geo_residential);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Residential");
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), geothermal.class);
                        startActivity(backButton);

                    }
                });
            }
        });
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "comView";
                setContentView(R.layout.geo_commercial);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Commercial");
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), geothermal.class);
                        startActivity(backButton);
                    }
                });
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                if(flag == "resView" || flag =="comView") {
                    Intent backButton = new Intent(getBaseContext(), geothermal.class);
                    startActivity(backButton);
                }else {
                    Intent backView = new Intent(getBaseContext(), Home.class);
                    startActivity(backView);
                }
            }
        });

    }
}


