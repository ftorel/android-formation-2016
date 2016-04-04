package junior.com.formation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.my_textview);

        textView.setText( getString(R.string.hello_world) );

        Button myBut = (Button) findViewById(R.id.my_button);
        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Coucou");
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
