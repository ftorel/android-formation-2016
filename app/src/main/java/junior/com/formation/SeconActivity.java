package junior.com.formation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeconActivity extends AppCompatActivity {

    private List<String> myList = new ArrayList<>();

    private ListView listView;
    private Button butSendBroadcast;
    private Button butAddToList;

    private MyAdapter customAdapter;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);

        setUpViews();

        //setCustomAdapter();

        setUpAdapter();

    }

    public void setSendBroadcastClick(View view){
        Intent intent = new Intent("a");
        intent.putExtra("b", "from second activity");
        sendBroadcast(intent);
    }

    public void setAddToListClick(View view){
        myList.add("salut");
        customAdapter.update(myList);
    }

    private void setUpViews(){
        listView = (ListView) findViewById(R.id.my_list);

        butSendBroadcast = (Button) findViewById(R.id.but_send_broad);
        butSendBroadcast.setText("Send broadcast");

        butAddToList = (Button) findViewById(R.id.but_add_list);
        butAddToList.setText("Add to list");
    }

    private void setUpAdapter(){

        final String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a = values[position];
                Toast.makeText(SeconActivity.this, a, Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void setCustomAdapter(){

        myList.add("hello");
        myList.add("coucou");

        customAdapter = new MyAdapter(getApplicationContext(), myList);
        listView.setAdapter(customAdapter);

    }

}
