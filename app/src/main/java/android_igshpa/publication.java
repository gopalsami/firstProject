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

public class publication extends Activity {
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    String flag = "mainView";
    @Override
    public void onBackPressed() {
        if (flag == "mainView") {
            Intent backView = new Intent(getBaseContext(), Home.class);
            startActivity(backView);
        } else {
            Intent backView = new Intent(getBaseContext(), publication.class);
            startActivity(backView);
        }
    }
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publications_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("Publications");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent backButton = new Intent(getBaseContext(), Home.class);
                startActivity(backButton);
            }
        });
        //Button pub1 = (Button) findViewById(R.id.pub1);
        Button pub2 = (Button) findViewById(R.id.pub2);
        Button pub3 = (Button) findViewById(R.id.pub3);
        Button pub4 = (Button) findViewById(R.id.pub4);
        Button pub5 = (Button) findViewById(R.id.pub5);
        Button pub6 = (Button) findViewById(R.id.pub6);
        TextView pub7 = (TextView) findViewById(R.id.pub7);

        pub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub2";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        pub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub3";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        pub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub4";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        pub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub5";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        pub6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub6";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });

        pub7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "pub7";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Publications");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), publication.class);
                        startActivity(backButton);
                    }
                });
            }
        });

    }
    /** Opens the URL in a browser */
    private void openURL() {
        checkConnection(this);
         if (flag == "pub2"){
            webview.loadUrl("https://igshpa.org/brochures-and-booklets");
        }else if (flag == "pub3"){
            webview.loadUrl("https://igshpa.org/manuals");
        }else if (flag == "pub4"){
            webview.loadUrl("https://igshpa.org/software");
        }else if (flag == "pub5"){
            webview.loadUrl("https://igshpa.org/case-studies");
        }else if (flag == "pub6"){
            webview.loadUrl("https://igshpa.org/advertising-opportunities");
        }else if (flag == "pub7") {
            webview.loadUrl("https://secure.touchnet.com/C20271_ustores/web/store_main.jsp?STOREID=33");
        }
        webview.requestFocus();
    }
    /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT */
    public  boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(publication.this);
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
            // Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

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

