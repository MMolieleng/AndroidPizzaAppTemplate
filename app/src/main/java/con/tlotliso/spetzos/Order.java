package con.tlotliso.spetzos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    private String item_name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            item_name = extras.getString("item_name");
        }

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(item_name);

        EditText ed = (EditText) findViewById(R.id.quantity);
        ed.setText("1");
    }

    public void authorize(View v){
        Intent intent = new Intent(Order.this, LoginActivity.class);
        startActivity(intent);
    }
}
