package id.web.hangga.deleterowanim;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linMain;
    ArrayList<Integer> colorlist = new ArrayList<Integer>();
    private int[] Warna = {Color.parseColor("#1FDA9A"),
            Color.parseColor("#DB3340"),
            Color.parseColor("#E8B71A"),
            Color.parseColor("#28ABE3"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#FF4081"),
            Color.parseColor("#303F9F"),
            Color.parseColor("#585858"),
            Color.BLUE,
            Color.CYAN,
            Color.DKGRAY,
            Color.GREEN,
            Color.MAGENTA,
            Color.RED
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linMain = (LinearLayout) findViewById(R.id.linMain);
        initColor();
        for (int i = 0; i < 20; i++){
            addItem();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }

    private void initColor(){
        for (int i = 0; i < Warna.length; i++){
            colorlist.add(Warna[i]);
        }
        Collections.shuffle(colorlist);

    }



    private void addItem(){
        final Child child = new Child(MainActivity.this, colorlist.get(new Random().nextInt(Warna.length)));

        child.getImgDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteRowAnimation anim = new DeleteRowAnimation(child);
                anim.setDuration(1000);
                child.startAnimation(anim);
            }
        });
        linMain.addView(child);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
