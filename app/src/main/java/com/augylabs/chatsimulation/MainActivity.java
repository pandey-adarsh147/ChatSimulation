package com.augylabs.chatsimulation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements WizardCallback {

    private WizardSimulation wizardSimulation;
    private LinearLayout list;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (LinearLayout) findViewById(R.id.list);
        button = (Button) findViewById(R.id.submit);

        wizardSimulation = new LaundryWizardSimulation();
        wizardSimulation.registerCallback(this);
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

    @Override
    public void onStartTyping() {
        TextView tv3 = new TextView(this);
        tv3.setTextSize(10);
        tv3.setGravity(Gravity.CENTER);
        tv3.setText("start typing...");

        list.addView(tv3);
    }

    @Override
    public void onStopTyping() {
        TextView tv3 = new TextView(this);
        tv3.setTextSize(10);
        tv3.setGravity(Gravity.CENTER);
        tv3.setText("stop typing...");

        list.addView(tv3);
    }

    @Override
    public void onReceiveCommand(Command command) {
        button.setEnabled(true);

        TextView tv3 = new TextView(this);
        tv3.setTextSize(10);
        tv3.setGravity(Gravity.CENTER);
        tv3.setText("receive new command");

        list.addView(tv3);
    }

    public void onSubmit(View view) {
        button.setEnabled(false);
        TextView tv3 = new TextView(this);
        tv3.setTextSize(10);
        tv3.setGravity(Gravity.CENTER);
        tv3.setText("submit response");

        list.addView(tv3);

        wizardSimulation.submitResponse(null);
    }
}
