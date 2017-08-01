package com.example.srivallikanchibotla.android_igshpa;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(null);
        getSupportActionBar().setTitle("Home");

        Button geo = (Button) findViewById(R.id.button);
        Button dir = (Button) findViewById(R.id.button3);
        Button mem = (Button) findViewById(R.id.button4);
        Button pub = (Button) findViewById(R.id.button5);
        Button tra = (Button) findViewById(R.id.button6);
        Button conf = (Button) findViewById(R.id.button7);
        Button outlook = (Button) findViewById(R.id.button9);
        Button login = (Button) findViewById(R.id.memberlogin);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        int[][] state = new int[][] {
                new int[] {android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {android.R.attr.state_enabled}, // unchecked
                new int[] {android.R.attr.state_enabled}  // pressed

        };
        int[] color = new int[] {
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };
        ColorStateList csl = new ColorStateList(state, color);
        navigationView.setItemTextColor(csl);

        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent geothermalView = new Intent(getBaseContext(), geothermal.class);
                startActivity(geothermalView);
            }
        });
        dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent directoryView = new Intent(getBaseContext(), directory.class);
                startActivity(directoryView);
            }
        });
        mem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent memView = new Intent(getBaseContext(), membership.class);
                startActivity(memView);
            }
        });
        pub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pubView = new Intent(getBaseContext(), publication.class);
                startActivity(pubView);
            }
        });
        tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent traView = new Intent(getBaseContext(), training.class);
                startActivity(traView);
            }
        });
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confView = new Intent(getBaseContext(), conferences.class);
                startActivity(confView);
            }
        });
        outlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoView = new Intent(getBaseContext(), geooutlook.class);
                startActivity(geoView);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginView = new Intent(getBaseContext(), login.class);
                startActivity(loginView);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("no", null).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home) {

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
//            Intent homepage = new Intent(getBaseContext(), Home.class);
//            startActivity(homepage);
        } else if (id == R.id.geothermal) {
            Intent geothermalView = new Intent(getBaseContext(), geothermal.class);
            startActivity(geothermalView);

        } else if (id == R.id.training) {
            Intent traView = new Intent(getBaseContext(), training.class);
            startActivity(traView);

        } else if (id == R.id.conference) {
            Intent confView = new Intent(getBaseContext(), conferences.class);
            startActivity(confView);
        } else if (id == R.id.publication){
            Intent pubView = new Intent(getBaseContext(), publication.class);
            startActivity(pubView);

        } else if (id == R.id.membership) {
            Intent memView = new Intent(getBaseContext(), membership.class);
            startActivity(memView);

        } else if (id == R.id.businessdirectory){
            Intent directoryView = new Intent(getBaseContext(), directory.class);
            startActivity(directoryView);
        }else if (id == R.id.geo){
            Intent directoryView = new Intent(getBaseContext(), geooutlook.class);
            startActivity(directoryView);
        }else if (id == R.id.about){
            Intent directoryView = new Intent(getBaseContext(), aboutus.class);
            startActivity(directoryView);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}