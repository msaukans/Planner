package tk.codester.maris.planner;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] l1;
    private final String[] l2;
    public CustomList(Activity context, String[] l1, String[] l2) {
        super(context, R.layout.list_single, l1);
        this.context = context;
        this.l1 = l1;
        this.l2 = l2;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.l1);

        TextView imageView = (TextView) rowView.findViewById(R.id.l2);
        txtTitle.setText(l1[position]);

        imageView.setText(l2[position]);
        return rowView;
    }
}