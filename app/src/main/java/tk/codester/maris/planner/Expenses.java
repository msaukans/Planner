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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Expenses extends AppCompatActivity {

    ListView exp_list;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<Expense> exp = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_expenses);

        arr.add("first");
        arr.add("Second");
        arr.add("third");
        arr.add("fourth");
        arr.add("fifth");




        adapter = new ArrayAdapter<String>(this, layout.listview, exp);
        exp_list = (ListView) findViewById(R.id.exp_list);
        exp_list.setAdapter(adapter);

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
