package be.vub.smappeerules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.R;
import be.vub.smappeerules.core.CoreFacade;
import be.vub.smappeerules.core.rule.Rule;

public class AlertLogActivity extends Activity {

    private ListView alerts;

    //rules need to be added to this array
    List<String> rulesArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_screen);
        alerts = (ListView)findViewById(R.id.alertsList);
        CoreFacade app= CoreFacade.getInstance(getApplicationContext());
       /** List<Rule> r= app.getAllRules();

        for(int i= 0; i< r.size();i++){
            rulesArray.add(r.get(i).getAlert());
        }**/
        //dummy population
        rulesArray = app.checkRules();




        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                rulesArray );

        alerts.setAdapter(arrayAdapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alert_log, menu);
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
