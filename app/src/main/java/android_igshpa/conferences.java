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

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Created by maheshkumarkankipati on 1/27/17.
 */

public class conferences extends Activity {
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    WebView webview;
    String flag = "mainView";
    @Override
    public void onBackPressed() {
        Intent backView = new Intent(getBaseContext(), Home.class);
        startActivity(backView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conferece_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        Button prgm = (Button) findViewById(R.id.prgmdetails);
        Button scanQR = (Button) findViewById(R.id.scan);
        Button main = (Button) findViewById(R.id.mainpage);
        Button floorplan = (Button) findViewById(R.id.floorplan);

        Calendar today = Calendar.getInstance();
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int month = today.get(Calendar.MONTH);
        int year = today.get(Calendar.YEAR);
        if (month == Calendar.MARCH && dayOfMonth <= 20 && year == 2017) {
            // button is enabled till march 20th 2017
            scanQR.setVisibility(View.VISIBLE);
            floorplan.setVisibility(View.VISIBLE);
        } else {
            scanQR.setVisibility(View.INVISIBLE);
            floorplan.setVisibility(View.INVISIBLE);
        }

        prgm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "prgmView";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Conferences");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), conferences.class);
                        startActivity(backButton);
                    }
                });
            }
        });

        scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent codescanner = new Intent(getBaseContext(), scanner.class);
                startActivity(codescanner);
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "mainWebView";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Conferences");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), conferences.class);
                        startActivity(backButton);
                    }
                });
            }
        });

        floorplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "floorView";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Floorplan");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), conferences.class);
                        startActivity(backButton);
                    }
                });
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent backButton = new Intent(getBaseContext(), Home.class);
                startActivity(backButton);
            }
        });

    }
    private void openURL() {
        checkConnection(this);
        if(flag == "floorView") {
            String pdf = "http://www.igshpa.okstate.edu/pdf_files/2017_conf/Floorplan.pdf";
            webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
        }else if(flag == "mainWebView"){
            webview.loadUrl("http://igshpa.org/conference");
        }else {
            webview.loadUrl("https://igshpa.org/members/");
        }
        webview.requestFocus();
    }
    public  boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(conferences.this);
        alertDialog.setTitle("Network Problem");

        // Setting Dialog Message
        alertDialog.setMessage("Please check your Internet Connection");
        alertDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                        onBackPressed();
                    }
                });
        alertDialog.setNeutralButton("Retry",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        overridePendingTransition(0, 0);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(intent);
                    }
                });

        if (activeNetworkInfo != null) { // connected to the internet
            //  Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        alertDialog.show();
        return false;
    }


}
