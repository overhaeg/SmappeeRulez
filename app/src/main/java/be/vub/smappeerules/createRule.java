package be.vub.smappeerules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import be.vub.smappeerules.R;


public class createRule extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rule);
        Button bSubmit = (Button) findViewById(R.id.ok);

        /** b.setOnClickListener(new OnClickListener(){

        @Override public void onClick(View v) {

        });
        }**/



        ArrayList<String> propertyoptions = new ArrayList<String>();
        propertyoptions.add("consumption");
        propertyoptions.add("production");


        ArrayList<String> groupoptions = new ArrayList<String>();
        groupoptions.add("Refrigirator");
        groupoptions.add("lamp");
        groupoptions.add("TV");


        fillRule(groupoptions, propertyoptions);

        bSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentMain = new Intent(createRule.this ,
                        MyActivity.class);
                createRule.this.startActivity(intentMain);
                Log.d(createRule().get(2), "hip hoy"+createRule().size());

            }



        });
    }

    public ArrayList<String> createRule(){
        Spinner dg1=(Spinner)findViewById(R.id.devgroup1) ;
        Spinner dg2=(Spinner)findViewById(R.id.devgroup2) ;
        Spinner dp1=(Spinner)findViewById(R.id.propert1) ;
        Spinner dp2=(Spinner)findViewById(R.id.propert2) ;
        Spinner cond=(Spinner)findViewById(R.id.condition) ;
        Button ok=(Button)findViewById(R.id.bCreate);
        EditText valueOrPercent=(EditText)findViewById(R.id.dateorvalue);
        EditText alertMessage=(EditText)findViewById(R.id.alertMessage);

        ArrayList<String> Rule= new ArrayList<String>();

        if (valueOrPercent.getText().toString()=="value"){//||dg2.getSelectedItem().toString()=="percentage") {
            // ARRAY of 5: device group, device method, condition, value, message
             Rule.add(dg1.getSelectedItem().toString());
             Rule.add(dp1.getSelectedItem().toString());
             if (cond.getSelectedItem().toString()=="not =")
                {Rule.add("!=");}
                else {Rule.add(cond.getSelectedItem().toString());}
             Rule.add(valueOrPercent.getText().toString());
             Rule.add(alertMessage.getText().toString());


            }
            else{
            //ARRAY of 6 device group, device method, condition, device group, device method, message
             Rule.add(dg1.getSelectedItem().toString());
             Rule.add(dp1.getSelectedItem().toString());
             if (cond.getSelectedItem().toString()=="not =")
                {Rule.add("!=");}
                else {Rule.add(cond.getSelectedItem().toString());}
             Rule.add(dg2.getSelectedItem().toString());
             Rule.add(dp2.getSelectedItem().toString());
             Rule.add(alertMessage.getText().toString());
            };
        return Rule;
    };



    public void fillRule(ArrayList groupoptions, ArrayList<String> propertyoptions)
        {
            ArrayList<String> andorlist= new ArrayList<String>();

            andorlist.add("AND");
            andorlist.add("OR");

            ArrayList<String> conditionlist= new ArrayList<String>();

            conditionlist.add("<");
            conditionlist.add("<=");
            conditionlist.add(">");
            conditionlist.add(">=");
            conditionlist.add("=");
            conditionlist.add("not =");

            // Fill the first device  group
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,groupoptions);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner mSpinner1=(Spinner)findViewById(R.id.devgroup1) ;
            mSpinner1.setAdapter(adapter1);


            // Fill the second device group
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,groupoptions);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner mSpinner2=(Spinner)findViewById(R.id.devgroup2) ;
            mSpinner2.setAdapter(adapter2);

            // Fill the first device property
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,propertyoptions);
           adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner mSpinner3=(Spinner)findViewById(R.id.propert1) ;
            mSpinner3.setAdapter(adapter3);

            // Fill the second device propery
            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,propertyoptions);
            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner mSpinner4=(Spinner)findViewById(R.id.propert2) ;
            mSpinner4.setAdapter(adapter4);

            ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,conditionlist);
            adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner mSpinner5=(Spinner)findViewById(R.id.condition) ;
            mSpinner5.setAdapter(adapter5);


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



