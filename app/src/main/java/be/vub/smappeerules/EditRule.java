package be.vub.smappeerules;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import be.vub.smappeerules.R;

public class EditRule extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rule);

        Spinner dg1=(Spinner)findViewById(R.id.devgroup1e) ;
        Spinner dg2=(Spinner)findViewById(R.id.devgroup2e) ;
        Spinner dp1=(Spinner)findViewById(R.id.propert1e) ;
        Spinner dp2=(Spinner)findViewById(R.id.propert2e) ;
        Spinner cond=(Spinner)findViewById(R.id.conditione) ;
        Button bSubmit = (Button) findViewById(R.id.ok);

        ArrayList<String> conditionlist= new ArrayList<String>();

        conditionlist.add("<");
        conditionlist.add("<=");
        conditionlist.add(">");
        conditionlist.add(">=");
        conditionlist.add("=");
        conditionlist.add("not =");

        ArrayList<String> propertyoptions = new ArrayList<String>();
        propertyoptions.add("consumption/production");
        propertyoptions.add("consumption");
        propertyoptions.add("production");


        ArrayList<String> groupoptions = new ArrayList<String>();
        groupoptions.add("Select applience");
        groupoptions.add("Refrigirator");
        groupoptions.add("lamp");
        groupoptions.add("TV");

        // Fill the first device  group
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,groupoptions);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner1=(Spinner)findViewById(R.id.devgroup1e) ;
        mSpinner1.setAdapter(adapter1);

        // Fill the second device group
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,groupoptions);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner2=(Spinner)findViewById(R.id.devgroup2e) ;
        mSpinner2.setAdapter(adapter2);

        // Fill the first device property
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,propertyoptions);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner3=(Spinner)findViewById(R.id.propert1e) ;
        mSpinner3.setAdapter(adapter3);

        // Fill the second device propery
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,propertyoptions);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner4=(Spinner)findViewById(R.id.propert2e) ;
        mSpinner4.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,conditionlist);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner5=(Spinner)findViewById(R.id.conditione) ;
        mSpinner5.setAdapter(adapter5);


        String dg1string= new String("Refrigirator");
        Integer dg1nr= new Integer(getNr(dg1string, groupoptions));
        dg1.setSelection(dg1nr);
    }

    public Integer getNr(String selection, ArrayList<String> options){
        Integer nr= new Integer(0);
        for(Integer i=0;i < options.size(); i++)
        {
            if (options.get(i)==selection){
                nr= i;
                Log.d("deim", i.toString());
            }
            else{
                Log.d("deim", "this device is no loger in the list or has changed names");

            }

        };
        return nr;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_rule, menu);
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
}
