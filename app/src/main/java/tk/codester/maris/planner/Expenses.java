package tk.codester.maris.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Expenses extends AppCompatActivity {

    ListView exp_list;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<Expense> exp = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Expense expense = new Expense("","");
    TextView text;

    String[] l1 = {
            "rent",
            "phone bill",
            "electricity",
            "car",
            "Magazine subscr",
            "Internet",
            "water"
    } ;

    String[] l2 = {
            "500",
            "20",
            "100",
            "200",
            "10",
            "40",
            "50"
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        Expense exp1 = new Expense("","");
        exp1.setName("name 1");
        exp1.setCost("cost 1");
        exp.add(exp1);
        Expense exp2 = new Expense("","");
        exp2.setName("name 2");
        exp2.setCost("cost 2");
        exp.add(exp2);
        Expense exp3 = new Expense("","");
        exp3.setName("name 3");
        exp3.setCost("cost 3");
        exp.add(exp3);

        text = (TextView) findViewById(R.id.text1);


        CustomList adapter = new CustomList(Expenses.this, l1, l2);
        exp_list = (ListView)findViewById(R.id.exp_list);
        exp_list.setAdapter(adapter);


        String n = exp.get(0).getName() + " " + exp2.getCost();
        text.setText(n);

        registerForContextMenu(exp_list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup, menu);
    }//end createContextMenu

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
                arr.get(info.position);
                String j = arr.get(info.position).trim();
                arr.remove(info.position);
                Toast.makeText(getApplicationContext(), j + " Deleted", Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();

                return true;
            case R.id.edit:
                //similar code in Asigment project

                return true;

        }
        return super.onContextItemSelected(item);
    }//popup menu finalised

    protected void onResume() {

        super.onResume();

    }

}
