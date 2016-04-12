package com.example.imrankhan.gridview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {


    Integer[] animals = {R.drawable.eagle,R.drawable.elephant,R.drawable.gorilla,R.drawable.panda,R.drawable.panther,R.drawable.polar,
            R.drawable.wonder5,R.drawable.wonder6,R.drawable.wonder7};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView)findViewById(R.id.gridview);
        final ImageView pic = (ImageView)findViewById(R.id.img);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                //send intent to start activity
                Intent intent = new Intent(getApplicationContext(),ImageAdapter.class);
                intent.putExtra("id",position);
                startActivity(intent);*/
                Toast.makeText(getApplicationContext(),"Selected " + (position + 1),Toast.LENGTH_LONG).show();
                pic.setImageResource(animals[position]);
            }

        });
    }

    private class ImageAdapter extends BaseAdapter {
        private Context context;

        //constrcutor
        public ImageAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return animals.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(animals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));


            return pic;
        }
    }

/*
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

*/

}
