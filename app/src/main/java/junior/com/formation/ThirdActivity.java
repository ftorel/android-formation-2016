package junior.com.formation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    TextView myTextView;

    /*
    EXTRA_TEXT and his value will be accessible from everywhere in the project
    public : the variable will be accessible from everywhere
    static : don't need to instantiate MainActivity to get the EXTRA_VALUE's value
    final : we can't change the value of EXTRA_VALUE
     */

    public static final String EXTRA_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        myTextView = (TextView) findViewById(R.id.my_textview);

        /*
        Get the key from MainActivity
         */

        String key = MainActivity.EXTRA_VALUE;

        if ( getIntent().hasCategory(key) ){
            String value = getIntent().getExtras().getString(key);
            myTextView.setText(value);
        }

        Button but = (Button) findViewById(R.id.my_button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("a");
                intent.putExtra(EXTRA_TEXT, "from thrid actvity");
                sendBroadcast(intent);
            }
        });

    }


}
