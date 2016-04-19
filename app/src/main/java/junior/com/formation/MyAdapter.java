package junior.com.formation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by floriantorel on 06/04/16.
 */
public class MyAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    private List<String> list = new ArrayList<>();

    public MyAdapter(Context context, List<String> myList){
        this.mInflater = LayoutInflater.from(context);
        this.list = myList;
    }

    public void update(){
        list.add("wesch");
        notifyDataSetChanged();
    }

    public void update( List<String> updatedList ){
        this.list = updatedList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        String myString = list.get(position);

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.custom_cell, null);

            holder.textView = (TextView) convertView.findViewById(R.id.custon_celle_textview);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        holder.textView.setText(myString);


        return convertView;
    }


    private class ViewHolder{
        TextView textView;
    }
}
