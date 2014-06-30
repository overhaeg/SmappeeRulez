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

        bcreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(MyActivity.this ,
                        createRule.class);
                MyActivity.this.startActivity(intentMain);
            }
        });

      /**View.OnClickListener handler = new View.OnClickListener(){

            public void onClick(View v) {

                if(v.equals(bcreate)){
                    // doStuff
                    Intent intentMain = new Intent(MyActivity.this ,
                            createRule.class);
                    MyActivity.this.startActivity(intentMain);
                    Log.i("Content ", " Main layout ");
                }
                Log.d(v);
               if(v==btnApp){
                    // doStuff
                    Intent intentApp = new Intent(CurrentActivity.this,
                            ThirdActivity.class);

                    CurrentActivity.this.startActivity(intentApp);

                    Log.i("Content "," App layout ");

                }**/


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
