package tk.codester.maris.planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView cashLeft;
    double payCheck, walkAroundCashLeft;
    FloatingActionButton fab;
    Button btn_Done;
    EditText exp_name, exp_cost;
    String name, cost;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cashLeft = (TextView) findViewById(R.id.CashLeft);

        payCheck = 700.00;
        walkAroundCashLeft = payCheck - 599;

       fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        btn_Done = (Button) findViewById(R.id.btn_Done);

        exp_name = (EditText) findViewById(R.id.ed1);
        exp_cost = (EditText) findViewById(R.id.ed2);

        cashLeft.setText("You have : \n" + walkAroundCashLeft + "$ left of spending money");
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
            startActivity(new Intent(MainActivity.this,Expenses.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if(fab == v){
            Toast.makeText(this, "Test success" +
                    "", Toast.LENGTH_SHORT).show();




        }

    }

}
