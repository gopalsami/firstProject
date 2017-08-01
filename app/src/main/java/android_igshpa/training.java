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
import android.widget.Toast;

/**
 * Created by maheshkumarkankipati on 1/27/17.
 */

public class training extends Activity {
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        Intent backView = new Intent(getBaseContext(), Home.class);
        startActivity(backView);
    }
    WebView webview;
    String flag = "mainView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("Training");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent backButton = new Intent(getBaseContext(), Home.class);
                startActivity(backButton);
            }
        });
        Button course1 = (Button) findViewById(R.id.course1);
        Button course2 = (Button) findViewById(R.id.course2);
        Button course3 = (Button) findViewById(R.id.course3);
        Button course4 = (Button) findViewById(R.id.course4);
        Button course5 = (Button) findViewById(R.id.course5);
        Button course6 = (Button) findViewById(R.id.course6);
        Button course7 = (Button) findViewById(R.id.course7);
        Button course8 = (Button) findViewById(R.id.course8);
        Button course9 = (Button) findViewById(R.id.course9);
        Button course10 = (Button) findViewById(R.id.course10);
        Button Resource1 = (Button) findViewById(R.id.resource1);
        Button Resource2 = (Button) findViewById(R.id.resource2);
        Button Resource3 = (Button) findViewById(R.id.resource3);

        course1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course1";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course2";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course3";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course4";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course5";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course6";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course7";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course8";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course9";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        course10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "course10";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        Resource1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "resource1";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        Resource2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "resource2";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });
        Resource3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "resource3";
                setContentView(R.layout.webview);
                Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
                TextView title = (TextView) findViewById(R.id.toolbar_title);
                title.setText("Training");
                webview=(WebView)findViewById(R.id.menuWebView);
                webview.setWebViewClient(new MyWebViewClient());
                openURL();
                toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // back button pressed
                        Intent backButton = new Intent(getBaseContext(), training.class);
                        startActivity(backButton);
                    }
                });
            }
        });


    }

    /** Opens the URL in a browser */
    private void openURL() {
        checkConnection(this);
        if(flag == "course1") {
            webview.loadUrl("http://www.igshpa.org/accredited-installer-workshops");
        }else if (flag == "course2"){
            webview.loadUrl("http://www.igshpa.org/certified-geoexchange-designer");
        }else if (flag == "course3"){
            webview.loadUrl("http://www.igshpa.org/certified-residential-geothermal-designer");
        }else if (flag == "course4"){
            webview.loadUrl("http://www.igshpa.org/certified-vertical-closed-loop-driller-prep");
        }else if (flag == "course5"){
            webview.loadUrl("http://www.igshpa.org/certified-vertical-closed-loop-driller-prep");
        }else if (flag == "course6"){
            webview.loadUrl("http://www.igshpa.org/train-trainer-course");
        }else if (flag == "course7"){
            webview.loadUrl("http://www.igshpa.org/training-events");
        }else if (flag == "course8"){
            webview.loadUrl("http://www.igshpa.org/short-courses#certified-dx-installer-course");
        }else if (flag == "course9"){
            webview.loadUrl("http://www.igshpa.org/short-courses#open-loop-geothermal-systems");
        }else if (flag == "course10"){
            webview.loadUrl("http://www.igshpa.org/short-courses#understanding-grouting-applications--innovations");
        }else if (flag == "resource1"){
            webview.loadUrl("http://www.igshpa.org/accreditation-renewal-information");
        }else if (flag == "resource2"){
            webview.loadUrl("http://www.igshpa.org/accredited-trainers");
        }else if (flag == "resource3"){
            webview.loadUrl("http://www.igshpa.org/training-events");
        }
        webview.requestFocus();
    }
    /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT */
    public  boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(training.this);
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
