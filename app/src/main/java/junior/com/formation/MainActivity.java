package junior.com.formation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  {

    private BroadcastReceiver broadcastReceiver;

    TextView textView;

    public static final String EXTRA_VALUE = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.my_textview);

        textView.setText(getString(R.string.hello_world));

        Button myBut = (Button) findViewById(R.id.my_button);

        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra(EXTRA_VALUE, "From mainactivity");
                startActivity(intent);
                finish();
            }
        });

        
        setUpBroadcast();

    }

    private void setUpBroadcast(){

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String text = intent.getStringExtra(ThirdActivity.EXTRA_TEXT);
                textView.setText(text);
            }
        };

        registerReceiver(broadcastReceiver, new IntentFilter("a"));
    }


    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
