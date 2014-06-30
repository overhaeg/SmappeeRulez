package be.vub.smappeerules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import be.vub.smappeerules.R;


public class createRule extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rule);
        Button addRule = (Button) findViewById(R.id.addRule);

        /** b.setOnClickListener(new OnClickListener(){

        @Override public void onClick(View v) {

        });
        }**/

        ArrayList<String> propertyoptions = new ArrayList<String>();
        propertyoptions.add("OR");

        ArrayList<String> groupoptions = new ArrayList<String>();
        groupoptions.add("AND");
    }


    public void fillRule(ArrayList groupoptions, ArrayList<String> propertyoptions)
        {
            ArrayList<String> andorlist= new ArrayList<String>();

            andorlist.add("AND");
            andorlist.add("OR");

            ArrayList<String> conditionlist= new ArrayList<String>();

            andorlist.add("<");
            andorlist.add("<=");
            andorlist.add(">");
            andorlist.add(">=");
            andorlist.add("=");
            andorlist.add("not =");
            // Fill the first device  group
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,groupoptions);
            Spinner mSpinner1=(Spinner)findViewById(R.id.devgroup1) ;
            mSpinner1.setAdapter(adapter1);

            // Fill the second device group
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,groupoptions);
            Spinner mSpinner2=(Spinner)findViewById(R.id.devgroup2) ;
            mSpinner2.setAdapter(adapter2);

            // Fill the first device property
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,propertyoptions);
            Spinner mSpinner3=(Spinner)findViewById(R.id.propert1) ;
            mSpinner3.setAdapter(adapter3);

            // Fill the second device propery
            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,groupoptions);
            Spinner mSpinner4=(Spinner)findViewById(R.id.propert2) ;
            mSpinner4.setAdapter(adapter4);

            ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,conditionlist);
            Spinner mSpinner5=(Spinner)findViewById(R.id.condition) ;
            mSpinner5.setAdapter(adapter5);

            ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,R.layout.activity_create_rule,andorlist);
            Spinner mSpinner6=(Spinner)findViewById(R.id.andor) ;
            mSpinner6.setAdapter(adapter6);
        };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_rule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




};



