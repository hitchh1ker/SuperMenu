package com.example.supermenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu.getClass().getSimpleName()
                .equals("MenuBuilder")){
            try{
                Method m = menu.getClass()
                        .getDeclaredMethod (
                                "setOptionalIconsVisible",
                                Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public void onHelpClick(MenuItem item)
    {
        Toast.makeText(getApplicationContext(),
                "Help clicked", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.CART:
                msg = "Cart clicked";
                break;
            case R.id.callPhone:
                msg = "Call clicked";
                break;
            case R.id.card:
                item.setChecked(true);
                msg = "Camera clicked";
                break;
            case R.id.video:
                item.setChecked(true);
                msg = "Video clicked";
                break;
            case R.id.EMAIL:
                msg = "Email clicked";
                break;
            case R.id.ADD:
                msg = "Add clicked";
                break;
            case R.id.COPY:
                msg = "Copy clicked";
                break;
            case R.id.PASTE:
                msg = "Paste clicked";
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }
}