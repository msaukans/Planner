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

import static android.R.layout.simple_list_item_1;

public class Expenses extends AppCompatActivity {

    ListView exp_list;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<Expense> exp = new ArrayList<>();
    ArrayAdapter<String> adapter;
    public Expense exp5 = new Expense("1","1") ;

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        arr.add("first");
        arr.add("Second");
        arr.add("third");
        arr.add("fourth");
        arr.add("fifth");
        String n1 = "name 1";
        String c1= "COST 1";

        Expense exp1 = new Expense(n1,c1);
        Expense exp2 = new Expense("name 2","cost 2");
        Expense exp3 = new Expense("name 3","cost 3");
        exp.add(exp1);
        exp.add(exp2);
        exp.add(exp3);

        text = (TextView) findViewById(R.id.text1);

        adapter = new ArrayAdapter<>(this, simple_list_item_1, arr);
        exp_list = (ListView) findViewById(R.id.exp_list);

        exp_list.setAdapter(adapter);

        String n = exp1.getName();
        String k = exp5.getCost() + "";
        text.setText(n);
        Toast.makeText(this, "result:            " +n , Toast.LENGTH_SHORT).show();

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
                String j = arr.get(info.position).toString().trim();
                arr.remove(info.position);
                Toast.makeText(getApplicationContext(), j + " Deleted", Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();

                return true;
            case R.id.edit:


                return true;

        }
        return super.onContextItemSelected(item);
    }//popup menu finalised

    protected void onResume() {

        super.onResume();

    }

    public void onClick(View view) {

    }//end onClick

}
