package be.vub.smappeerules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final Button bcreate=(Button)findViewById(R.id.bCreate);
        final Button bgroup=(Button)findViewById(R.id.bAppl);
        final Button bmanage=(Button)findViewById(R.id.bManage);
        final Button bhelp=(Button)findViewById(R.id.bHelp);
        final Button blog=(Button)findViewById(R.id.bLog);
        bcreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(MyActivity.this ,
                        createRule.class);
                MyActivity.this.startActivity(intentMain);
            }
        });

        bgroup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(MyActivity.this ,
                        AddGroupActivity.class);
                MyActivity.this.startActivity(intentMain);
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(MyActivity.this ,
                       AlertLogActivity.class);
                MyActivity.this.startActivity(intentMain);
            }
        });

        bhelp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(MyActivity.this ,
                        Help.class);
                MyActivity.this.startActivity(intentMain);
            }


        });



    };



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.hgfgf
        //oijoijoi
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //lets test that
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
