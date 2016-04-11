package junior.com.formation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    TextView myTextView;

    public static final String EXTRA_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myTextView = (TextView) findViewById(R.id.my_textview);

        String value = getIntent().getExtras().getString(MainActivity.EXTRA_VALUE);

        myTextView.setText(value);

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
