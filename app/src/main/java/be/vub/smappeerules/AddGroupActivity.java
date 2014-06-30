package be.vub.smappeerules;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import be.vub.smappeerules.R;

public class AddGroupActivity extends Activity {

    private ListView groups;
    private EditText editName;
    private Button btnValidate;

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

        btnValidate.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){

                    String name = editName.getText().toString();
                    //gives array with checked positions on true
                    SparseBooleanArray checkedPositions = groups.getCheckedItemPositions();
                    //app.storeGroup(name, deviceArray);
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
