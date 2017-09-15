package tk.codester.maris.planner;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
    double payCheck, walkAroundCashLeft, exp_total;
    FloatingActionButton fab;
    Button btn_Done;
    EditText exp_name, exp_cost, salary_in;
    String name, cost;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cashLeft = (TextView) findViewById(R.id.CashLeft);

        exp_total = 599;

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String j =sp.getString("exp_j",null);//get saved salary
        Toast.makeText(this, j, Toast.LENGTH_SHORT).show();
        payCheck = Double.parseDouble(j);//switch salary from string to double
        salaryCheck();
        walkAroundCashLeft = payCheck - exp_total;//how much cash does the person has left

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
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setTitle("Add Box");
            dialog.setContentView(R.layout.add_box);
            TextView txtMessage = (TextView) dialog.findViewById(R.id.editMessage);
            txtMessage.setText(R.string.Add_Expense);
            final EditText edName = (EditText) dialog.findViewById(R.id.textInputA);
            final EditText edCost = (EditText) dialog.findViewById(R.id.textInputB);
            name = edName.getText().toString();
            cost = edCost.getText().toString();

            Button bt = (Button) dialog.findViewById(R.id.btDone);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //what happens when clicked done

                    Toast.makeText(MainActivity.this,  "Expense " + name + " has been added", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();




        }

    }

    public void salaryCheck(){
        if(payCheck == 0.0){
            Toast.makeText(this, "please add your salary",  Toast.LENGTH_SHORT).show();

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setTitle("Salary Missing Box");
            dialog.setContentView(R.layout.salary_input);

            salary_in = (EditText) dialog.findViewById(R.id.salary_in);

            Button bt_sal = (Button) dialog.findViewById(R.id.btn_Done_salary_in);
            bt_sal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //what happens when clicked done
                    String pc = String.valueOf(salary_in.getText());
                    if(pc == pc){//validating the users input

                    }
                    payCheck = Double.parseDouble(pc);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("exp_j", pc);
                    editor.commit();
                    Toast.makeText(MainActivity.this, pc + " " + payCheck + " Salary " + payCheck + " has been added", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }


}
