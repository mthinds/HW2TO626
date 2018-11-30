package com.example.mthin.hw2to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class InventoryCheckActivity extends Activity implements View.OnClickListener {

    Button buttonHome;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_check);

        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuitemhome) {
            Intent intentmenu = new Intent(this, HomeActivity.class);
            startActivity(intentmenu);
        } else if (item.getItemId() == R.id.menuitemcheck) {
            Intent intentmenu = new Intent(this, InventoryCheckActivity.class);
            startActivity(intentmenu);
        } else if (item.getItemId() == R.id.menuitemadd) {
            Intent intentmenu = new Intent(this, AddInventoryActivity.class);
            startActivity(intentmenu);
        } else if (item.getItemId() == R.id.menuitemlogout) {
            FirebaseAuth.getInstance().signOut();
            Intent intentmenu = new Intent(this, MainActivity.class);
            startActivity(intentmenu);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonHome) {
            Intent intentProfile = new Intent(this, HomeActivity.class);
            startActivity(intentProfile);
        }
    }
}