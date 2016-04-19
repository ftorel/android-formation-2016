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

    /*
    Register global variables
     */

    /*
    private : means broadcastReceiver will be accessible only on this class
     */
    private BroadcastReceiver broadcastReceiver;

    /*
    without argument : textView will be accessible for the entire package
     */

    TextView textView;

    /*
    EXTRA_VALUE and his value will be accessible from everywhere in the project
    public : the variable will be accessible from everywhere
    static : don't need to instantiate MainActivity to get the EXTRA_VALUE's value
    final : we can't change the value of EXTRA_VALUE
     */
    public static final String EXTRA_VALUE = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        findViewById return the view from the activity_main layout which has the same id
        we need to use a cast (TextView) to make the returned view a textview
         */

        textView = (TextView) findViewById(R.id.my_textview);
        textView.setText(getString(R.string.hello_world));


        Button myBut = (Button) findViewById(R.id.my_button);
        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startThirdActivity_broadcastreceiver();

                startSecondActivity_broadcastreceiverAndListview();

                //finish();
            }
        });

        
        setUpBroadcast();

    }

    private void startSecondActivity_broadcastreceiverAndListview(){
        Intent intent = new Intent(MainActivity.this, SeconActivity.class);
        startActivity(intent);
    }

    private void startThirdActivity_broadcastreceiver(){

        /*
        Call for the on click event on the my_button Button
        */

        /*
        Intent object : An Intent is exactly what it describes. It's an "intention" to do an action.
        An Intent is basically a message to say you did or want something to happen.
        Depending on the intent, apps might be listening for it and will react accordingly
        */

        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

        intent.putExtra(EXTRA_VALUE, "From mainactivity");

        /*
        We start another activity : ThirdActivity.class
        With a special intent
        */

        startActivity(intent);





        /*
        We finish the activity
        */

    }

    private void setUpBroadcast(){

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                /*
                Call for when we receive the broadcast from sendBroast(); whit the correct intent filter
                */
                String text = intent.getStringExtra(ThirdActivity.EXTRA_TEXT);
                textView.setText(text);
            }
        };

        /*
        We register the broadcast from the onCreate() method, at the beginning of the activity's lifecylce
        We register it with a IntentFilter "a" in order to target particular intent
         */

        registerReceiver(broadcastReceiver, new IntentFilter("a"));
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /*
        We unregister the broadcast on the onDestroy, at the end of the activity's lifecycle
         */

        unregisterReceiver(broadcastReceiver);

    }
}
