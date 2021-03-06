package com.example.mthin.hw2to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends Activity implements View.OnClickListener {

    Button buttonInventoryCheck, buttonAddInventory, buttonLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonInventoryCheck = findViewById(R.id.buttonInventoryCheck);
        buttonAddInventory = findViewById(R.id.buttonAddInventory);
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonInventoryCheck.setOnClickListener(this);
        buttonAddInventory.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
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
        if (v == buttonInventoryCheck) {
            Intent intentProfile = new Intent(HomeActivity.this, InventoryCheckActivity.class);
            startActivity(intentProfile);
        } else if (v == buttonAddInventory) {
            Intent intentProfile = new Intent(HomeActivity.this, AddInventoryActivity.class);
            startActivity(intentProfile);
        } else if (v == buttonLogout) {
            FirebaseAuth.getInstance().signOut();
            Intent intentProfile = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intentProfile);
        }
    }
}