package com.yurii.car;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle;
    Button btnModel, btnEngine, btnColor;
    String model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnModel = (Button) findViewById(R.id.btnModel);
        btnModel.setOnCreateContextMenuListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       getMenuInflater().inflate(R.menu.context1,menu);
    }
    Fragment Adam;
    Fragment Agila;
    Fragment Astra;
    Fragment Cascada;
    @Override
    public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.model_1:
                    loadFragment(Adam);
                    break;
                case R.id.model_2:
                    loadFragment(Agila);
                    break;
                case R.id.model_3:
                    loadFragment(Astra);
                    break;
                case R.id.model_4:
                    loadFragment(Cascada);
                    break;
            }
            return true;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.mainitem1:
                Toast.makeText(this, "Додаток створив студент групи КНТ-519 Юрій Герасін", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mainitem2:
                finish();
                break;
        }
        return true;
    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

}