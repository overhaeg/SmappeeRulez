package be.vub.smappeerules;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import be.vub.smappeerules.R;
import be.vub.smappeerules.core.device.Device;
import be.vub.smappeerules.core.device.DeviceGroup;

public class AddGroupActivity extends Activity {

    private ListView groups;
    private EditText editName;
    private Button btnValidate;
    private DeviceGroup deviceGroup;
    //devices need to be added to this array
    List<String> deviceArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_group);

        groups =(ListView) findViewById(R.id.groups);
        btnValidate = (Button) findViewById(R.id.validate);
        editName = (EditText)findViewById(R.id.editName);


        groups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // change the background color of the selected element
            view.setBackgroundColor(Color.LTGRAY);
            }

        }
        );

        //dummy population
        deviceArray.add("Koffiezet");
        deviceArray.add("Wasmachine");
        deviceArray.add("Playstation");
        deviceArray.add("TV");
        deviceArray.add("Oven");
        deviceArray.add("Radio");


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                deviceArray );

        groups.setAdapter(arrayAdapter);

        btnValidate.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){

                    String name = editName.getText().toString();
                    deviceGroup = new DeviceGroup(name);
                    //gives array with checked positions on true
                    SparseBooleanArray checkedPositions = groups.getCheckedItemPositions();

                    for(int i = 0; i< deviceArray.size(); i++ ) {
                        if (checkedPositions.get(i)) {

                            Device d = new Device(deviceArray.get(i));
                            deviceGroup.addToGroup(d);
                        }
                    }
                    deviceGroup.writeToFile();

                    finish();
            }
            }

            );
        }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_group, menu);
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
